package com.meminksr.exceptionhandlingapi.exception;

public class ResourceNotFoundException extends RuntimeException {

    // Hata fırlatılırken içine "Kullanıcı bulunamadı" gibi bir mesaj yazabilmek için constructor (yapıcı metot) ekledim.
    public ResourceNotFoundException(String message) {
        super(message);
    }
}