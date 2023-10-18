package Matrix;

public class Pecahan {
    private int pembilang;
    private int penyebut;

    public Pecahan(int pembilang, int penyebut) {
        this.pembilang = pembilang;
        this.penyebut = penyebut;
    }

    public Pecahan tambah(Pecahan pl) {
        int newPembilang = (this.pembilang * pl.penyebut) + (pl.pembilang * this.penyebut);
        int newPenyebut = this.penyebut * pl.penyebut;
        return new Pecahan(newPembilang, newPenyebut);
    }

    public Pecahan kurang(Pecahan pl) {
        int newPembilang = (this.pembilang * pl.penyebut) - (pl.pembilang * this.penyebut);
        int newPenyebut = this.penyebut * pl.penyebut;
        return new Pecahan(newPembilang, newPenyebut);
    }

    public Pecahan kali(Pecahan pl) {
        int newPembilang = this.pembilang * pl.pembilang;
        int newPenyebut = this.penyebut * pl.penyebut;
        return new Pecahan(newPembilang, newPenyebut);
    }

    public Pecahan bagi(Pecahan pl) {
        int newPembilang = this.pembilang * pl.penyebut;
        int newPenyebut = this.penyebut * pl.pembilang;
        return new Pecahan(newPembilang, newPenyebut);
    }

    @Override
    public String toString() {
        return pembilang + "/" + penyebut;
    }
}