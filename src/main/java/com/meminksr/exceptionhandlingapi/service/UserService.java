package com.meminksr.exceptionhandlingapi.service;

import com.meminksr.exceptionhandlingapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserById(Long id) {

        // Gerçek bir projede burada veritabanına bağlanıp kullanıcıyı arardık.
        // Şemadaki senaryoyu (3. Adım) birebir canlandırmak için,
        // eğer gelen ID 99 ise veritabanında bulamamışız gibi davranıp hatamızı fırlatıyoruz.
        if (id == 99) {
            throw new ResourceNotFoundException("Kullanıcı DB'de yok! Aranan ID: " + id);
        }

        // Eğer 99 dışında bir ID gelirse, sorunsuz çalışacak.
        return "Kullanıcı başarıyla getirildi. ID: " + id;
    }
}