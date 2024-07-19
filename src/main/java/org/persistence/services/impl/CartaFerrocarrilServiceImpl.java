package org.persistence.services.impl;

import org.model.card.CartaFerrocarril;
import org.model.enums.TipoTarjeta;
import org.modelmapper.ModelMapper;
import org.persistence.entities.CartaFerrocarrilEntity;
import org.persistence.repositories.CartaFerrocarrilRepository;
import org.persistence.services.CartaFerrocarrilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartaFerrocarrilServiceImpl implements CartaFerrocarrilService {
    @Autowired
    CartaFerrocarrilRepository cartaFerrocarrilRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CartaFerrocarrilServiceImpl(CartaFerrocarrilRepository cartaFerrocarrilRepository){
        this.cartaFerrocarrilRepository=cartaFerrocarrilRepository;
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
    public CartaFerrocarril GuardarCartaFerrocarril(CartaFerrocarril cartaFerrocarril) {
        CartaFerrocarrilEntity auxGuardar = new CartaFerrocarrilEntity();
        auxGuardar.setDescripcion(cartaFerrocarril.getDescripcion());
        auxGuardar.setValorHipoteca(cartaFerrocarril.getValorHipoteca());
        auxGuardar.setValorAlquiler(cartaFerrocarril.getValor());
        auxGuardar.setIdDuenio(cartaFerrocarril.getIdDuenio());
        auxGuardar.setTipoTarjeta(cartaFerrocarril.getTipoTarjeta().getValue());
        cartaFerrocarrilRepository.save(auxGuardar);
        cartaFerrocarril.setId(auxGuardar.getId());
        return cartaFerrocarril;
    }

    @Override
    public List<CartaFerrocarril> BuscarCartas() {
       List<CartaFerrocarril> auxReturn = new ArrayList<>();
       List<CartaFerrocarrilEntity> listCards = cartaFerrocarrilRepository.findAll();
       for(CartaFerrocarrilEntity carta : listCards){
           CartaFerrocarril cartaFerrocarril = modelMapper.map(carta, CartaFerrocarril.class);
           cartaFerrocarril.setTipoTarjeta(this.getTipoByInt(carta.getTipoTarjeta()));
           auxReturn.add(cartaFerrocarril);
       }
       return auxReturn;
    }

    @Override
    public CartaFerrocarril BuscarCarta(Long idCarta) {
        Optional<CartaFerrocarrilEntity> cartaEntity = cartaFerrocarrilRepository.findById(idCarta);
        CartaFerrocarril auxReturn = null;
        if(cartaEntity.isPresent()){
            auxReturn = modelMapper.map(cartaEntity.get(), CartaFerrocarril.class);
            auxReturn.setTipoTarjeta(this.getTipoByInt(cartaEntity.get().getTipoTarjeta()));
        }
        return auxReturn;
    }

    @Override
    public CartaFerrocarril ActualizarCarta(CartaFerrocarril cartaFerrocarril) {
        Optional<CartaFerrocarrilEntity> cartaEntity = cartaFerrocarrilRepository.findById(cartaFerrocarril.getId());
        if(cartaEntity.isPresent()){
            cartaEntity.get().setIdDuenio(cartaFerrocarril.getIdDuenio());
            cartaFerrocarrilRepository.save(cartaEntity.get());
            return cartaFerrocarril;
        }
        return null;
    }

    @Override
    public boolean BorrarCarta(Long idCarta) {
        boolean auxReturn = false;
        Optional<CartaFerrocarrilEntity> auxDelete = cartaFerrocarrilRepository.findById(idCarta);
        if(auxDelete.isPresent()){
            cartaFerrocarrilRepository.delete(auxDelete.get());
            auxReturn=true;
        }
        return auxReturn;
    }

    @Override
    public void BorrarCartas() {
        cartaFerrocarrilRepository.deleteAll();
    }
}
