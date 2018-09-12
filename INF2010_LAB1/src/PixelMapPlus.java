import java.awt.PageAttributes.ColorType;

/**
 * Classe PixelMapPlus
 * Image de type noir et blanc, tons de gris ou couleurs
 * Peut lire et ecrire des fichiers PNM
 * Implemente les methodes de ImageOperations
 * @author : 
 * @date   : 
 */

public class PixelMapPlus extends PixelMap implements ImageOperations 
{
	/**
	 * Constructeur creant l'image a partir d'un fichier
	 * @param fileName : Nom du fichier image
	 */
	PixelMapPlus(String fileName)
	{
		super( fileName );
	}
	
	/**
	 * Constructeur copie
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(PixelMap image)
	{
		super(image); 
	}
	
	/**
	 * Constructeur copie (sert a changer de format)
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(ImageType type, PixelMap image)
	{
		super(type, image); 
	}
	
	/**
	 * Constructeur servant a allouer la memoire de l'image
	 * @param type : type d'image (BW/Gray/Color)
	 * @param h : hauteur (height) de l'image 
	 * @param w : largeur (width) de l'image
	 */
	PixelMapPlus(ImageType type, int h, int w)
	{
		super(type, h, w);
	}
	
	/**
	 * Genere le negatif d'une image
	 */
	public void negate()
	{
		// compl�ter
		for(AbstractPixel[] abstractPixels: imageData) {
			for(AbstractPixel abstractPixel : abstractPixels) {
				abstractPixel= abstractPixel.Negative();
			}
		}
	}
	
	/**
	 * Convertit l'image vers une image en noir et blanc
	 */
	public void convertToBWImage()
	{
		// compl�ter
		for(AbstractPixel[] abstractPixels: imageData) {
			for(AbstractPixel abstractPixel : abstractPixels) {
				abstractPixel= abstractPixel.toBWPixel();
			}
		}
	}
	
	/**
	 * Convertit l'image vers un format de tons de gris
	 */
	public void convertToGrayImage()
	{
		// compl�ter
		for(AbstractPixel[] abstractPixels: imageData) {
			for(AbstractPixel abstractPixel : abstractPixels) {
				abstractPixel= abstractPixel.toGrayPixel();
			}
		}
	}
	
	/**
	 * Convertit l'image vers une image en couleurs
	 */
	public void convertToColorImage()
	{
		// compl�ter
		for(AbstractPixel[] abstractPixels: imageData) {
			for(AbstractPixel abstractPixel : abstractPixels) {
				abstractPixel= abstractPixel.toColorPixel();
			}
		}
	}
	
	public void convertToTransparentImage()
	{
		// compl�ter
		for(AbstractPixel[] abstractPixels: imageData) {
			for(AbstractPixel abstractPixel : abstractPixels) {
				abstractPixel= abstractPixel.toTransparentPixel();
			}
		}
	}
	
	
	/**
	 * Modifie la longueur et la largeur de l'image 
	 * @param w : nouvelle largeur
	 * @param h : nouvelle hauteur
	 */
	public void resize(int w, int h) throws IllegalArgumentException
	{
		if(w < 0 || h < 0)
        throw new IllegalArgumentException();
        
        AbstractPixel[][] newImage = new AbstractPixel[h][w];
        //double ratioH = this.height/h;
        double ratioW = this.width/w;
        if(ratioW < 1){
            ratioW = 1/ratioW;
            int j=0;
            double shit = 0;
            for(int i = 0; i<this.width;i++){
                shit +=ratioW;
                while(shit>=1){
                    newImage[j]= imageData[i];
                    ratioW--;
                    j++;
                }
            }
        }
        else if( ratioW >1){
            double shit =0;
            int j=0;
            for(int i = 0; i<this.width;){
                shit +=ratioW;
                while(shit>=1){
                    ratioW--;
                    i++;
                }
                newImage[j]= imageData[i];
            }
        }
        else{
            for(int i = 0; i<this.width;i++){
                newImage[i]= imageData[i];
            }
        }
		
	}
	
	/**
	 * Insert pm dans l'image a la position row0 col0
	 */
	public void insert(PixelMap pm, int row0, int col0)
	{
		// compl�ter
			for (int i= 0; i < pm.height && i < height; i++)
				for(int j= 0; j < pm.width && j < width; j++)
					imageData[i + row0][j+ col0] = pm.imageData[i][j];			
			}
		}
	}
	
	/**
	 * Decoupe l'image 
	 */
	public void crop(int h, int w)
	{
		// compl�ter	
		for (int i= h; i < this.height; i++)
			for(int j = w; j < this.width ; j++)
				imageData[i][j] = null;
				
					
		
			
		
	}
	
	/**
	 * Effectue une translation de l'image 
	 */
	public void translate(int rowOffset, int colOffset)
	{
		// compl�ter		
		
	}
	
}
