package org.persistence.services.impl;

import org.model.card.CartaCompania;
import org.model.card.CartaProvincia;
import org.model.enums.TipoTarjeta;
import org.modelmapper.ModelMapper;
import org.persistence.entities.CartaEmpresaEntity;
import org.persistence.entities.CartaProvinciaEntity;
import org.persistence.repositories.CartaEmpresaRepository;
import org.persistence.services.CartaEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ComponentScan("org.persistence.repositories")
public class CartaEmpresaServiceImpl implements CartaEmpresaService {
    @Autowired
    private CartaEmpresaRepository cartaEmpresaRepository;
    @Qualifier("modelMapper")
    @Autowired
    private ModelMapper modelMapper;

    public CartaEmpresaServiceImpl(CartaEmpresaRepository cartaEmpresaRepository){
        this.cartaEmpresaRepository = cartaEmpresaRepository;
    }

    public TipoTarjeta getTipoByInt(int tipo){
        switch (tipo){
            case 1: return TipoTarjeta.FERROCARRIL;
            case 2: return TipoTarjeta.COMPANIA;
            case 3: return TipoTarjeta.PROVINCIA;
            default: return null;
        }
    }

    @Override
    public CartaCompania GuardarCartaEmpresa(CartaCompania cartaCompania) {
        CartaEmpresaEntity auxGuardar = new CartaEmpresaEntity();
        auxGuardar.setDescripcion(cartaCompania.getDescripcion());
        auxGuardar.setValorHipoteca(cartaCompania.getValorHipoteca());
        auxGuardar.setValorAlquiler(cartaCompania.getValor());
        auxGuardar.setIdDuenio(cartaCompania.getIdDuenio());
        auxGuardar.setTipoTarjeta(cartaCompania.getTipoCarta().getValue());
        cartaEmpresaRepository.save(auxGuardar);
        cartaCompania.setId(auxGuardar.getId());
        return cartaCompania;
    }

    @Override
    public List<CartaCompania> BuscarCartas() {
        List<CartaCompania> auxReturn = new ArrayList<>();
        List<CartaEmpresaEntity> auxList = cartaEmpresaRepository.findAll();
        for (CartaEmpresaEntity cartaEmpresaEntity : auxList) {
            CartaCompania auxCard = modelMapper.map(cartaEmpresaEntity, CartaCompania.class);
            auxCard.setTipoTarjeta(this.getTipoByInt(cartaEmpresaEntity.getTipoTarjeta()));
            auxReturn.add(auxCard);
        }
        return auxReturn;
    }

    @Override
    public CartaCompania BuscarCarta(Long idCarta) {
        Optional<CartaEmpresaEntity> cartaEntity = cartaEmpresaRepository.findById(idCarta);
        CartaCompania auxReturn = null;
        if(cartaEntity.isPresent()){
            auxReturn = modelMapper.map(cartaEntity.get(), CartaCompania.class);
            auxReturn.setTipoTarjeta(this.getTipoByInt(cartaEntity.get().getTipoTarjeta()));
        }
        return auxReturn;
    }

    @Override
    public CartaCompania ActualizarCarta(CartaCompania cartaCompania) {
        Optional<CartaEmpresaEntity> cartaEntity = cartaEmpresaRepository.findById(cartaCompania.getId());
        if(cartaEntity.isPresent()){
            cartaEntity.get().setIdDuenio(cartaCompania.getIdDuenio());
            this.cartaEmpresaRepository.save(cartaEntity.get());
            return cartaCompania;
        }
        return null;
    }

    @Override
    public boolean BorrarCarta(Long idCarta) {
        boolean auxReturn = false;
        Optional<CartaEmpresaEntity> auxDelete = cartaEmpresaRepository.findById(idCarta);
        if(auxDelete.isPresent()){
            cartaEmpresaRepository.delete(auxDelete.get());
            auxReturn = true;
        }
        return auxReturn;
    }

    @Override
    public void BorrarCartas() {
        cartaEmpresaRepository.deleteAll();
    }
}
