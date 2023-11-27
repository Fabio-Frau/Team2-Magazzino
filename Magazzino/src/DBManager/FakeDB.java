package DBManager;

import Login.ArchivioUtenti;
import Magazzino.Magazzino;

public class FakeDB {

    private Magazzino magazzino;
    private ArchivioUtenti archivioUtenti;



    public FakeDB(Magazzino magazzino, ArchivioUtenti archivioUtenti) {
        this.magazzino = magazzino;
        this.archivioUtenti = archivioUtenti;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    public ArchivioUtenti getArchivioUtenti() {
        return archivioUtenti;
    }

    public void setArchivioUtenti(ArchivioUtenti archivioUtenti) {
        this.archivioUtenti = archivioUtenti;
    }
}
