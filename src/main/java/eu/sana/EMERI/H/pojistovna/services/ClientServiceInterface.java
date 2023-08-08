package eu.sana.EMERI.H.pojistovna.services;

import eu.sana.EMERI.H.pojistovna.models.ClientDTO;

import java.util.List;

public interface ClientServiceInterface {
    void create(ClientDTO clientDTO);
    List<ClientDTO> getAll();

    ClientDTO getById(long clientId);
    void editClient(ClientDTO clientDTO);
    void  removeClient(long clientId);

    List<ClientDTO>searchResult(String name);
}
