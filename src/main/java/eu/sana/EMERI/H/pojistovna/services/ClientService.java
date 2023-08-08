package eu.sana.EMERI.H.pojistovna.services;

import eu.sana.EMERI.H.pojistovna.data.entities.ClientEntity;
import eu.sana.EMERI.H.pojistovna.data.repositories.ClientRepositoryInterface;
import eu.sana.EMERI.H.pojistovna.mappers.ClientMapperInterface;
import eu.sana.EMERI.H.pojistovna.models.ClientDTO;
import eu.sana.EMERI.H.pojistovna.models.exeptions.ClientNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ClientService implements ClientServiceInterface {
    @Autowired
    private ClientRepositoryInterface clientRepositoryInterface;

    @Autowired
    private ClientMapperInterface clientMapperInterface;


    @Override
    public void create(ClientDTO clientDTO) {
        ClientEntity newClient = clientMapperInterface.toEntity(clientDTO);
        clientRepositoryInterface.save(newClient);
    }

    @Override
    public List<ClientDTO> getAll() {
        return StreamSupport.stream(clientRepositoryInterface.findAll().spliterator(),false).map(i -> clientMapperInterface.toDTO(i)).toList();
    }
    private ClientEntity getOfTrow(long clientId){

        return clientRepositoryInterface
                .findById(clientId)
                .orElseThrow(ClientNotFoundExeption::new);
    }

    @Override
    public ClientDTO getById(long clientId) {
ClientEntity fetchedClient = getOfTrow(clientId);
        return clientMapperInterface.toDTO(fetchedClient);
    }

    @Override
    public void editClient(ClientDTO clientDTO) {
ClientEntity fetchedClient = getOfTrow(clientDTO.getClientId());
clientMapperInterface.updateClientEntity(clientDTO, fetchedClient);

clientRepositoryInterface.save(fetchedClient);

    }

    @Override
    public void removeClient(long clientId) {
        ClientEntity fetchedClient = getOfTrow(clientId);
        clientRepositoryInterface.delete(fetchedClient);
    }

    @Override
    public List<ClientDTO> searchResult(String search) {
        List<ClientDTO> clients = StreamSupport.stream(clientRepositoryInterface.findAll().spliterator(),false).map(i -> clientMapperInterface.toDTO(i)).toList();
        List<ClientDTO> fetchedClients = new ArrayList<>();
        for(ClientDTO client : clients){
            if(client.getJmeno().equalsIgnoreCase(search)||client.getPrijmeni().equalsIgnoreCase(search)||client.getEmail().equalsIgnoreCase(search)||client.getTelefon().equalsIgnoreCase(search)){
            fetchedClients.add(client);
        }}
        return fetchedClients;
    }


}
