package Login;

import java.util.ArrayList;

public class ArchivioUtenti {
    private ArrayList<Utente> archivioUtenti;

    public ArchivioUtenti(ArrayList<Utente> archivioUtenti) {
        this.archivioUtenti = archivioUtenti;
    }

    public boolean addUtente(Cliente cliente) {

        if (getUtenteByEmail(cliente.getEmail()) == null) {
            this.archivioUtenti.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    public Utente checkCredentials(String email, String psw) {
        for (Utente utente : this.archivioUtenti) {
            if (utente.getEmail().equals(email) ) {
                if (utente.getPassword().equals(psw)) {
                    return utente;
                }
            }
        }
        return null;
    }

    public Utente getUtenteByEmail(String email) {
        for (Utente utente : archivioUtenti) {
            if (utente.getEmail().equals(email)) {
                return utente;
            }
        }
        return null;
    }


    public ArrayList<Utente> getArchivioUtenti() {
        return archivioUtenti;
    }

    public void setLista(ArrayList<Utente> lista) {
        this.archivioUtenti = lista;
    }



}
