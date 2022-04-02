package time;

import java.util.ArrayList;

/**
 * La classe rappresenta e gestisce dati di tipo temporale
 */
public class Time {

    /**
     * numero di ore dell'oggetto Time
     */
    protected int ore;
    /**
     * numero di minuti dell'oggetto Time
     */
    protected int minuti;
    /**
     * numero di secondi dell'oggetto Time
     */
    protected int secondi;

    /**
     * Costruisce un oggetto Time dato in ingresso ore, minuti e secondi.<br>
     * Se i parametri di ingresso non sono validi (es. minuti 78) allora l'oggetto Time verra' inizializzato con tutti ore, minuti e secondi impostati a 0
     * @param ore ore da assegnare al nuovo oggetto
     * @param minuti minuti da assegnare al nuovo oggetto
     * @param secondi secondi da assegnare al nuovo oggetto
     */
    public Time(int ore, int minuti, int secondi) {
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    /**
     * Costruisce un oggetto Time dato in ingresso il numero di secondi<br>
     * <u>Vengono distribuite in automatico i secondi tra le ore, minuti e secondi.</u> Esempio: se in input viene passato 100 allora ora 0, minuti 1 e secondi 40
     * @param secondi secondi da assegnare al nuovo oggetto
     */
    public Time(int secondi) {
        try {
            normalizeTime(secondi);
        } catch (Exception e) {
            this.ore = 0;
            this.minuti = 0;
            this.secondi = 0;
        }
    }

    /**
     * Restituisce il numero delle ore
     * @return il numero di ore dell'oggetto time
     */
    public int getOre() {
        return this.ore;
    }

    /**
     * @param ore
     * @deprecated
     */
    public void setOre(int ore) {
        this.ore = ore;
    }

    /**
     * Restituisce il numero di minuti
     * @return il numero di minuti dell'oggetto Time
     */
    public int getMinuti() {
        return this.minuti;
    }

    /**
     * @param minuti
     * @deprecated
     */
    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    /**
     * Restituisce il numero di secondi
     * @return il numero di secondi dell'oggetto time
     */
    public int getSecondi() {
        return this.secondi;
    }

    /**
     * @param secondi
     * @deprecated
     */
    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    /**
     * Esprime le ore, i minuti e i secondi dell'oggetto Time in secondi
     * @return il numero totale dei secondi
     */
    public int convertiSecondi() {
        return this.ore * 3600 + this.minuti * 60 + this.secondi;
    }

    /**
     * Vengono addizionati il numero di secondi specificati. Il tempo viene
     * normalizzato in automatico.
     * 
     * @param secondi numero di secondi da aggiungere
     */
    public void addSecondi(int secondi) {
        try {
            normalizeTime(this.convertiSecondi() + secondi);
        } catch (Exception e) {
            this.ore = 0;
            this.minuti = 0;
            this.secondi = 0;
        }
    }

    /**
     * Restituisce una stringa che rappresenta l'oggetto
     * @return Rappresentazione testuale dell'oggetto Time {ore:minuti:secondi}<br>
     */
    @Override
    public String toString() {
        return "{" +
                " minuti='" + getMinuti() + "'" +
                ", ore='" + getOre() + "'" +
                ", secondi='" + getSecondi() + "'" +
                "}";
    }

    private void normalizeTime(int secondi) throws Exception {
        if (secondi > 0) {
            this.ore = secondi / 3600;
            this.minuti = (secondi % 3600) / 60;
            this.secondi = secondi % 60;
        }
        throw new Exception("I secondi inseriti devono essere maggiori di 0");
    }
}
