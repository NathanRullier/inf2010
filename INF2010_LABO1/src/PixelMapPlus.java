import java.awt.PageAttributes.ColorType;

import com.sun.scenario.effect.ImageData;

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
        
        
        double ratioH = this.height/h;
        double ratioW = this.width/w;
        double compteurH=ratioH;
        double compteurW=ratioW;
        if(ratioH > 1 && ratioW > 1) {
        	for(int i=0;i<this.height;i++) {
        		compteurH--;
            	if(compteurH<=1) {
            		for(int j = 0; j<this.width;j++) {
        				compteurW--;
            			if(compteurW<=1) {
            				if(i<h && j<w) {
            					newImage[i][j]=this.imageData[i][j];            					            					
            				}
            				compteurW+=ratioW;
            			}
            		}
            		compteurH+=ratioH;
            	}
            }
        }
        
        this.width = w;
        this.height = h;
        imageData= new AbstractPixel[h][w];
        for(int i=0;i<h;i++) {
        		for(int j = 0; j<h;j++) {
        			imageData[i][j] = newImage[i][j];
        		}
        }
        		
        /*if(ratioW < 1){
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
            double compteur =0;
            int j=0;
            for(int i = 0; i<this.width;){
                compteur +=ratioW;
                while(compteur>=1){
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
	*/	
	}
	
	/**
	 * Insert pm dans l'image a la position row0 col0
	 */
	public void insert(PixelMap pm, int row0, int col0)
	{
		// compl�ter
			for (int i= 0; i < pm.height && i < height; i++) {
				for(int j= 0; j < pm.width && j < width; j++) {
					if(i+row0 < this.height && j+col0 < this.width)
					imageData[i + row0][j+ col0] = pm.imageData[i][j];			
			}
		}
			row0++;
	}
	
	/**
	 * Decoupe l'image 
	 */
	public void crop(int h, int w)
	{
		// compl�ter	
		AbstractPixel[][] newImage = new AbstractPixel[h][w];
		for (int i= 0; i < this.height; i++) {
			for(int j = 0; j < this.width ; j++) {
				if(this.height<=i && this.width <= j) {
					newImage[i][j] = imageData[i][j];					
				}
				else {
					newImage[i][j] = new BWPixel();					
				}
			}
		}
		imageData = newImage;
		this.height = h;
		this.width = w;
	}
	
	/**
	 * Effectue une translation de l'image 
	 */
	public void translate(int rowOffset, int colOffset)
	{
		for (int i= 0; i < this.height; i++) {
			for(int j = 0; j < this.width ; j++) {
				if(j+rowOffset > this.height || i+colOffset > this.width ) {
					imageData[i][i].setAlpha(255);;
				}
				else {
					imageData[i][j] = imageData[i+rowOffset][j+colOffset];					
				}
			}
		}
		rowOffset++;
	}
	
}
