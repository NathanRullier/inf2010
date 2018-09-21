import java.awt.PageAttributes.ColorType;

import com.sun.scenario.effect.ImageData;

/**
 * Classe PixelMapPlus Image de type noir et blanc, tons de gris ou couleurs
 * Peut lire et ecrire des fichiers PNM Implemente les methodes de
 * ImageOperations
 * 
 * @author :
 * @date :
 */

public class PixelMapPlus extends PixelMap implements ImageOperations {
	/**
	 * Constructeur creant l'image a partir d'un fichier
	 * 
	 * @param fileName : Nom du fichier image
	 */
	PixelMapPlus(String fileName) {
		super(fileName);
	}

	/**
	 * Constructeur copie
	 * 
	 * @param type  : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(PixelMap image) {
		super(image);
	}

	/**
	 * Constructeur copie (sert a changer de format)
	 * 
	 * @param type  : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(ImageType type, PixelMap image) {
		super(type, image);
	}

	/**
	 * Constructeur servant a allouer la memoire de l'image
	 * 
	 * @param type : type d'image (BW/Gray/Color)
	 * @param h    : hauteur (height) de l'image
	 * @param w    : largeur (width) de l'image
	 */
	PixelMapPlus(ImageType type, int h, int w) {
		super(type, h, w);
	}

	/**
	 * Genere le negatif d'une image
	 */
	public void negate() {
		// compl�ter
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				imageData[i][j] = imageData[i][j].Negative();
			}
		}
	}

	/**
	 * Convertit l'image vers une image en noir et blanc
	 */
	public void convertToBWImage() {
		// compl�ter
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				imageData[i][j] = imageData[i][j].toBWPixel();
			}
		}
	}

	/**
	 * Convertit l'image vers un format de tons de gris
	 */
	public void convertToGrayImage() {
		// compl�ter
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				imageData[i][j] = imageData[i][j].toGrayPixel();
			}
		}
	}

	/**
	 * Convertit l'image vers une image en couleurs
	 */
	public void convertToColorImage() {
		// compl�ter
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				imageData[i][j] = imageData[i][j].toColorPixel();
			}
		}
	}

	public void convertToTransparentImage() {
		// compl�ter
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				imageData[i][j] = imageData[i][j].toTransparentPixel();
			}
		}
	}

	/**
	 * Modifie la longueur et la largeur de l'image
	 * 
	 * @param w : nouvelle largeur
	 * @param h : nouvelle hauteur
	 */
	public void resize(int w, int h) throws IllegalArgumentException {
		if (w < 0 || h < 0)
			throw new IllegalArgumentException();

		AbstractPixel[][] newImage = new AbstractPixel[h][w];
		//finds the height and width ratio
		double ratioH = this.height / h;
		double ratioW = this.width / w;
		//helps to count where the ratio is
		double compteurH = ratioH;
		double compteurW = ratioW;
		//position in the new image
		int newImagePosH = 0;
		int newImagePosW = 0;
		//verify that the ratio means a reduction in size
		if (ratioH > 1 && ratioW > 1) {
			//goes through the height of the image
			for (int i = 0; i < this.height; i++) {
				compteurH--;
				if (newImagePosH == h) {
					break;
				}
				if (compteurH <= 1) {
					//goes through the width of the image
					for (int j = 0; j < this.width; j++) {
						compteurW--;
						if (newImagePosW == w) {
							break;
						}
						if (compteurW <= 1) {
							AbstractPixel a = this.imageData[i][j];
							newImage[newImagePosH][newImagePosW] = this.imageData[i][j];
							newImagePosW++;
							compteurW += ratioW;
						}

					}
					compteurH += ratioH;
					newImagePosH++;
				}
				newImagePosW = 0;
			}
		}
		//initialize the new image
		this.width = w;
		this.height = h;
		imageData = newImage;
	}

	/**
	 * Insert pm dans l'image a la position row0 col0
	 */
	public void insert(PixelMap pm, int row0, int col0) {
		// compl�ter
		for (int i = 0; i < pm.height && i < height; i++) {
			for (int j = 0; j < pm.width && j < width; j++) {
				if (i + row0 < this.height && j + col0 < this.width)
					imageData[i + row0][j + col0] = pm.imageData[i][j];
			}
		}
		row0++;
	}

	/**
	 * Decoupe l'image
	 */
	public void crop(int h, int w) {
		// compl�ter
		AbstractPixel[][] newImage = new AbstractPixel[h][w];
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (this.height <= i && this.width <= j) {
					newImage[i][j] = imageData[i][j];
				} else {
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
	public void translate(int rowOffset, int colOffset) {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (j + rowOffset > this.height || i + colOffset > this.width) {
					imageData[i][i].setAlpha(255);
					;
				} else {
					imageData[i][j] = imageData[i + rowOffset][j + colOffset];
				}
			}
		}
		rowOffset++;
	}

}
