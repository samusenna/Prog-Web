public class TesteMusica {
    public static void main(String[] args) {
        Trap a = new Trap("Limão", "Wiu", "30PRAUM", "WIU", true, 2.30);
        Trap b = new Trap("Avião", "Tue", "30PRAUM", "WIU", false, 3.09);
        Trap c = new Trap("ciumenta", "Wiu", "30PRAUM", "WIU", true, 3.50);

        Album album = new Album("Manual de como amar alguem errado", 3, "12/12/2022");


        album.adicionarMusica(a);
        album.adicionarMusica(b);
        album.adicionarMusica(c);

        album.buscarCompositor("Tue");

        album.buscarPornome("Limão");

        album.listarMusicasAlbum();
        a.tempoTotalDeMusica();


    }
}
