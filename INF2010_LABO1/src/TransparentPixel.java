/**
 * Classe de pixel transparent
 * @author :
 * @date : 
 */

public class TransparentPixel extends AbstractPixel
{
	public int[] rgba; // donnees de l'image
	
	/**
	 * Constructeur par defaut (pixel blanc)
	 */
	TransparentPixel()
	{
		rgba = new int[4];
		rgba[0] = 255;
		rgba[1] = 255;
		rgba[2] = 255;
		rgba[3] = 255;
	}
	
	/**
	 * Assigne une valeur au pixel
	 * @param rgb: valeurs a assigner 
	 */
	TransparentPixel(int[] rgba)
	{
		// compléter
		this.rgba = new int[4];
		this.rgba[0] = rgba[0];
        this.rgba[1] = rgba[1];
        this.rgba[2] = rgba[2];
        this.rgba[3] = rgba[3];
	}
	
	/**
	 * Renvoie un pixel copie de type noir et blanc
	 */
	public BWPixel toBWPixel()
	{
		// compléter
		double moy = (this.rgba[0]+this.rgba[1]+this.rgba[2])/3;
                if(moy>127){
                    return new BWPixel(true);
                }
                else{
                    return new BWPixel(false);
                }
	}
	
	/**
	 * Renvoie un pixel copie de type tons de gris
	 */
	public GrayPixel toGrayPixel()
	{
		// compléter
            double moy = (this.rgba[0]+this.rgba[1]+this.rgba[2])/3;
            
            return new GrayPixel((int)moy);
	}
	
	/**
	 * Renvoie un pixel copie de type couleurs
	 */
	public ColorPixel toColorPixel()
	{
		// compléter
            int [] rgb = {this.rgba[0],this.rgba[1],this.rgba[2]};
            
            return new ColorPixel(rgb);
	}
	
	/**
	 * Renvoie le negatif du pixel (255-pixel)
	 */
	public TransparentPixel Negative()
	{
		// compléter
		int [] rgban = {255-this.rgba[0],255-this.rgba[1],255-this.rgba[2],255};
		return new TransparentPixel(rgban);
	}
	
	public TransparentPixel toTransparentPixel()
	{
		// compléter
		return new TransparentPixel(this.rgba);
	}
	
	public void setAlpha(int alpha)
	{
		rgba[3] = alpha;
	}
	
	/**
	 * Convertit le pixel en String (sert a ecrire dans un fichier 
	 * (avec un espace supplémentaire en fin)s
	 */
	public String toString()
	{
		return  ((Integer)rgba[0]).toString() + " " + 
				((Integer)rgba[1]).toString() + " " +
				((Integer)rgba[2]).toString() + " " +
				((Integer)rgba[3]).toString() + " ";
	}
}
