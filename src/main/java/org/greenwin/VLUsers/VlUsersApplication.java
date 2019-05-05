package org.greenwin.VLUsers;

import org.greenwin.VLUsers.configuration.ApplicationPropertiesConfiguration;
import org.greenwin.VLUsers.entities.AppRole;
import org.greenwin.VLUsers.entities.AppUser;
import org.greenwin.VLUsers.repositories.AppRoleRepository;
import org.greenwin.VLUsers.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("org.greenwin")
@EnableDiscoveryClient
public class VlUsersApplication implements CommandLineRunner {

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ApplicationPropertiesConfiguration configuration;

	public static void main(String[] args) {
		SpringApplication.run(VlUsersApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {


	    AppRole admin = new AppRole( "ADMIN");
        AppRole productor = new AppRole( "AUTOR");
        AppRole consumer = new AppRole( "JOURNALIST");
        AppRole deliverer = new AppRole( "STATISTICIAN");

        AppUser julien = new AppUser("juliencauwet@yahoo.fr","12345");
        AppUser eric = new AppUser("dhallunie@hotmail.fr", "12345");
        AppUser bruno = new AppUser("b.gerussi@gmail.com", "12345");

        appUserRepository.save(julien);
        appUserRepository.save(eric);

        appRoleRepository.save(admin);
        appRoleRepository.save(productor);
        appRoleRepository.save(consumer);
        appRoleRepository.save(deliverer);

    }
}

