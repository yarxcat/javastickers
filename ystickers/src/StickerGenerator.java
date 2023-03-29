import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public void criar(InputStream inputstream, String nomeArquivo) throws Exception {
        
       BufferedImage imgOriginal =ImageIO.read(inputstream);

        // leitura da imagem (arquivo)
        //InputStream inputstream = new FileInputStream(new File("imagens/filme.jpg"));
        //BufferedImage imgOriginal = ImageIO.read(inputstream);
        // leitura de imagem (url)
        //InputStream inputstream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_3.jpg").openStream();
        //BufferedImage imgOriginal = ImageIO.read(inputstream);

        //criar uma nova img com transparencia e tamanho
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        float novaAltura = altura*1.2f;
        BufferedImage novaImagen = new BufferedImage(largura, (int)novaAltura, BufferedImage.TRANSLUCENT); 
        
        // copiar img original em memória
        // Usamos o getgraphics para buscra a img e escrever
        Graphics2D graphics = (Graphics2D)novaImagen.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        
        // configurando uma nova fonte
        var fonte = new Font("Impact", Font.BOLD, 128);
        graphics.setFont(fonte);
        graphics.setColor(Color.BLACK);

        // escrever uma frase na nova imagem
        graphics.drawString("assista", largura/2 - 100 , novaAltura - 100);

        
        // escrever a nova img em um arquivo
        ImageIO.write(novaImagen, "png", new File("saida/",nomeArquivo));
    }
}

