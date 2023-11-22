package Login;

import java.util.ArrayList;

public class ListaUtenti {
    private ArrayList<Utente> listaUtenti = new ArrayList<>();

    public ListaUtenti(ArrayList<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    public ListaUtenti() {

    }

    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public void setLista(ArrayList<Utente> lista) {
        this.listaUtenti = lista;
    }


}
