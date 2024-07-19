package org.persistence.services.impl;

import org.model.card.CartaProvincia;
import org.model.enums.Provincias;
import org.model.enums.TipoTarjeta;
import org.modelmapper.ModelMapper;
import org.persistence.entities.CartaProvinciaEntity;
import org.persistence.repositories.CartaPropiedadRepository;
import org.persistence.services.CartaProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ComponentScan("org.persistence.repositories")
public class CartaProvinciaServiceImpl implements CartaProvinciaService {
    @Autowired
    private CartaPropiedadRepository cartaPropiedadRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CartaProvinciaServiceImpl(CartaPropiedadRepository cartaPropiedadRepository) {
        this.cartaPropiedadRepository = cartaPropiedadRepository;
    }

    public TipoTarjeta getTipoByInt(int tipo){
        switch (tipo){
            case 1: return TipoTarjeta.FERROCARRIL;
            case 2: return TipoTarjeta.COMPANIA;
            case 3: return TipoTarjeta.PROVINCIA;
            default: return null;
        }
    }

    public Provincias getProvinciaByInt(int provincia){
        switch(provincia){
            case 1: return Provincias.FORMOSA;
            case 2: return Provincias.RIO_NEGRO;
            case 3: return Provincias.SALTA;
            case 4: return Provincias.MENDOZA;
            case 5: return Provincias.SANTA_FE;
            case 6: return Provincias.TUCUMAN;
            case 7: return Provincias.BUENOS_AIRES;
            case 8: return Provincias.CORDOBA;
            default: return null;
        }
    }

    @Override
    public CartaProvincia GuardarCartaProvincia(CartaProvincia cartaProvincia) {
        CartaProvinciaEntity auxGuardar = new CartaProvinciaEntity();
        auxGuardar.setIdDuenio(cartaProvincia.getIdDuenio());
        auxGuardar.setHipotecado(cartaProvincia.isHipotecado());
        auxGuardar.setDescripcion(cartaProvincia.getDescripcion());
        auxGuardar.setValorAlquiler(cartaProvincia.getValorAlquiler());
        auxGuardar.setConteoChacras(cartaProvincia.getConteoChacras());
        auxGuardar.setConteoEstancias(cartaProvincia.getConteoEstancias());
        auxGuardar.setValorChacra(cartaProvincia.getValorChacra());
        auxGuardar.setValorEstancia(cartaProvincia.getValorEstancia());
        auxGuardar.setValorHipoteca(cartaProvincia.getValorHipoteca());
        auxGuardar.setTipoCarta(cartaProvincia.getTipoCarta().getValue());
        auxGuardar.setProvincia(cartaProvincia.getProvincias().getValue());
        cartaPropiedadRepository.save(auxGuardar);
        cartaProvincia.setIdCarta(auxGuardar.getIdCarta());
        return cartaProvincia;
    }

    @Override
    public List<CartaProvincia> BuscarCartas() {
        List<CartaProvincia> auxReturn = new ArrayList<>();
        List<CartaProvinciaEntity> auxList = cartaPropiedadRepository.findAll();
        for (CartaProvinciaEntity cartaProvinciaEntity : auxList) {
            CartaProvincia auxCard = modelMapper.map(cartaProvinciaEntity, CartaProvincia.class);
            auxCard.setProvincia(this.getProvinciaByInt(cartaProvinciaEntity.getProvincia()));
            auxCard.setTipoCarta(this.getTipoByInt(cartaProvinciaEntity.getTipoCarta()));
            auxReturn.add(auxCard);
        }
        return auxReturn;
    }

    @Override
    public CartaProvincia BuscarCartaProvincia(Long id) {
        Optional<CartaProvinciaEntity> cartaEntity = cartaPropiedadRepository.findById(id);
        CartaProvincia auxReturn = null;
        if(cartaEntity.isPresent()){
            auxReturn = modelMapper.map(cartaEntity.get(), CartaProvincia.class);
            auxReturn.setTipoCarta(this.getTipoByInt(cartaEntity.get().getTipoCarta()));
            auxReturn.setProvincia(this.getProvinciaByInt(cartaEntity.get().getProvincia()));
        }
        return auxReturn;
    }

    @Override
    public CartaProvincia ActualizarCarta(CartaProvincia cartaProvincia) {
        Optional<CartaProvinciaEntity> cartaProvinciaEntity = cartaPropiedadRepository.findById(cartaProvincia.getIdCarta());
        if(cartaProvinciaEntity.isPresent()){
            cartaProvinciaEntity.get().setConteoChacras(cartaProvincia.getConteoChacras());
            cartaProvinciaEntity.get().setConteoEstancias(cartaProvincia.getConteoEstancias());
            cartaProvinciaEntity.get().setHipotecado(cartaProvincia.isHipotecado());
            cartaProvinciaEntity.get().setIdDuenio(cartaProvincia.getIdDuenio());
            this.cartaPropiedadRepository.save(cartaProvinciaEntity.get());
            return cartaProvincia;
        }
        return null;
    }

    @Override
    public boolean BorrarCarta(Long id) {
        boolean auxReturn = false;
        Optional<CartaProvinciaEntity> auxDelete = cartaPropiedadRepository.findById(id);
        if(auxDelete.isPresent()){
            cartaPropiedadRepository.delete(auxDelete.get());
            auxReturn = true;
        }
        return auxReturn;
    }

    @Override
    public void BorrarCartas() {
        cartaPropiedadRepository.deleteAll();
    }
}
