package Matrix;

public class Matrik {
    public Pecahan[][] data;
    private int baris;
    private int kolom;

    public Matrik(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
        data = new Pecahan[baris][kolom];
    }

    public void tambah(Matrik pl) {
        if (this.baris != pl.baris || this.kolom != pl.kolom) {
            System.out.println("Penjumlahan matriks tidak dapat dilakukan karena ukurannya yang berbeda.");
            return;
        }

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                data[i][j] = data[i][j].tambah(pl.data[i][j]);
            }
        }
    }

    public void kurang(Matrik pl) {
        if (this.baris != pl.baris || this.kolom != pl.kolom) {
            System.out.println("Pengurangan matriks tidak dapat dilakukan karena ukurannya yang berbeda.");
            return;
        }

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                data[i][j] = data[i][j].kurang(pl.data[i][j]);
            }
        }
    }

    public Matrik dot(Matrik pl) {
        if (this.kolom != pl.baris) {
            System.out.println("Perkalian matriks tidak dapat dilakukan karena ukurannya yang berbeda.");
            return new Matrik(0, 0);
        }

        Matrik hasil = new Matrik(this.baris, pl.kolom);

        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < pl.kolom; j++) {
                Pecahan sum = new Pecahan(0, 1);
                for (int k = 0; k < this.kolom; k++) {
                    sum = sum.tambah(this.data[i][k].kali(pl.data[k][j]));
                }
                hasil.data[i][j] = sum;
            }
        }

        return hasil;
    }

    public Matrik transpose() {
        Matrik hasil = new Matrik(this.kolom, this.baris);

        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < this.kolom; j++) {
                hasil.data[j][i] = this.data[i][j];
            }
        }

        return hasil;
    }

    public Matrik inverse() {
        if (this.baris != this.kolom) {
            System.out.println("Tidak dapat membalikkan matriks jika matriks tersebut bukan matriks persegi.");
            return new Matrik(0, 0);
        }

        int n = this.baris;
        Matrik augmentedMatriks = new Matrik(n, 2 * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatriks.data[i][j] = this.data[i][j];
                augmentedMatriks.data[i][j + n] = (i == j) ? new Pecahan(1, 1) : new Pecahan(0, 1);
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder hasil = new StringBuilder();
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil.append(data[i][j]).append(" ");
            }
            hasil.append("\n");
        }
        return hasil.toString();
    }
}