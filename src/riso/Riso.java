package riso;

import java.util.ArrayList;
import java.util.HashMap;
import processing.awt.PGraphicsJava2D;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;

/**
 * 
 * Helpful notes about subclassing PGraphics:
 * https://forum.processing.org/two/discussion/16314/pshape-inside-a-class-or-extend-pshape#Item_4
 * 
 * https://discourse.processing.org/t/is-it-possible-to-extend-the-classes-pgraphics-pgraphics3d/1593
 * 
 * (the tag example followed by the name of an example included in folder
 * 'examples' will automatically include the example in the javadoc.)
 *
 * @example Hello
 */

public class Riso extends PGraphicsJava2D {

	public final static String VERSION = "##library.prettyVersion##";

	public final static HashMap<String, Integer> RISOCOLORS;

	static {
		RISOCOLORS = new HashMap<String, Integer>();

		RISOCOLORS.put("BLACK", 0x000000);
		RISOCOLORS.put("BURGUNDY", 0x914e72);
		RISOCOLORS.put("BLUE", 0x0078bf);
		RISOCOLORS.put("GREEN", 0x00a95c);
		RISOCOLORS.put("MEDIUMBLUE", 0x3255a4);
		RISOCOLORS.put("BRIGHTRED", 0xf15060);
		RISOCOLORS.put("RISOFEDERALBLUE", 0x3d5588);
		RISOCOLORS.put("PURPLE", 0x765ba7);
		RISOCOLORS.put("TEAL", 0x00838a);
		RISOCOLORS.put("FLATGOLD", 0xbb8b41);
		RISOCOLORS.put("HUNTERGREEN", 0x407060);
		RISOCOLORS.put("RED", 0xff665e);
		RISOCOLORS.put("BROWN", 0x925f52);
		RISOCOLORS.put("YELLOW", 0xffe800);
		RISOCOLORS.put("MARINERED", 0xd2515e);
		RISOCOLORS.put("ORANGE", 0xff6c2f);
		RISOCOLORS.put("FLUORESCENTPINK", 0xff48b0);
		RISOCOLORS.put("LIGHTGRAY", 0x88898a);
		RISOCOLORS.put("METALLICGOLD", 0xac936e);
		RISOCOLORS.put("CRIMSON", 0xe45d50);
		RISOCOLORS.put("FLUORESCENTORANGE", 0xff7477);
		RISOCOLORS.put("CORNFLOWER", 0x62a8e5);
		RISOCOLORS.put("SKYBLUE", 0x4982cf);
		RISOCOLORS.put("SEABLUE", 0x0074a2);
		RISOCOLORS.put("LAKE", 0x235ba8);
		RISOCOLORS.put("INDIGO", 0x484d7a);
		RISOCOLORS.put("MIDNIGHT", 0x435060);
		RISOCOLORS.put("MIST", 0xd5e4c0);
		RISOCOLORS.put("GRANITE", 0xa5aaa8);
		RISOCOLORS.put("CHARCOAL", 0x70747c);
		RISOCOLORS.put("SMOKYTEAL", 0x5f8289);
		RISOCOLORS.put("STEEL", 0x375e77);
		RISOCOLORS.put("SLATE", 0x5e695e);
		RISOCOLORS.put("TURQUOISE", 0x00aa93);
		RISOCOLORS.put("EMERALD", 0x19975d);
		RISOCOLORS.put("GRASS", 0x397e58);
		RISOCOLORS.put("FOREST", 0x516e5a);
		RISOCOLORS.put("SPRUCE", 0x4a635d);
		RISOCOLORS.put("MOSS", 0x68724d);
		RISOCOLORS.put("SEAFOAM", 0x62c2b1);
		RISOCOLORS.put("KELLYGREEN", 0x67b346);
		RISOCOLORS.put("LIGHTTEAL", 0x009da5);
		RISOCOLORS.put("IVY", 0x169b62);
		RISOCOLORS.put("PINE", 0x237e74);
		RISOCOLORS.put("LAGOON", 0x2f6165);
		RISOCOLORS.put("VIOLET", 0x9d7ad2);
		RISOCOLORS.put("ORCHID", 0xaa60bf);
		RISOCOLORS.put("PLUM", 0x845991);
		RISOCOLORS.put("RAISIN", 0x775d7a);
		RISOCOLORS.put("GRAPE", 0x6c5d80);
		RISOCOLORS.put("SCARLET", 0xf65058);
		RISOCOLORS.put("TOMATO", 0xd2515e);
		RISOCOLORS.put("CRANBERRY", 0xd1517a);
		RISOCOLORS.put("MAROON", 0x9e4c6e);
		RISOCOLORS.put("RASPBERRYRED", 0xd1517a);
		RISOCOLORS.put("BRICK", 0xa75154);
		RISOCOLORS.put("LIGHTLIME", 0xe3ed55);
		RISOCOLORS.put("SUNFLOWER", 0xffb511);
		RISOCOLORS.put("MELON", 0xffae3b);
		RISOCOLORS.put("APRICOT", 0xf6a04d);
		RISOCOLORS.put("PAPRIKA", 0xee7f4b);
		RISOCOLORS.put("PUMPKIN", 0xff6f4c);
		RISOCOLORS.put("BRIGHTOLIVEGREEN", 0xb49f29);
		RISOCOLORS.put("BRIGHTGOLD", 0xba8032);
		RISOCOLORS.put("COPPER", 0xbd6439);
		RISOCOLORS.put("MAHOGANY", 0x8e595a);
		RISOCOLORS.put("BISQUE", 0xf2cdcf);
		RISOCOLORS.put("BUBBLEGUM", 0xf984ca);
		RISOCOLORS.put("LIGHTMAUVE", 0xe6b5c9);
		RISOCOLORS.put("DARKMAUVE", 0xbd8ca6);
		RISOCOLORS.put("WINE", 0x914e72);
		RISOCOLORS.put("GRAY", 0x928d88);
		RISOCOLORS.put("CORAL", 0xff8e91);
		RISOCOLORS.put("WHITE", 0xffffff);
		RISOCOLORS.put("AQUA", 0x5ec8e5);
		RISOCOLORS.put("MINT", 0x82d8d5);
		RISOCOLORS.put("CLEARMEDIUM", 0xf2f2f2);
		RISOCOLORS.put("FLUORESCENTYELLOW", 0xffe916);
		RISOCOLORS.put("FLUORESCENTRED", 0xff4c65);
		RISOCOLORS.put("FLUORESCENTGREEN", 0x44d62c);

	};

	private PApplet applet;

	public ArrayList<Color> channels = new ArrayList<Color>();

	public Riso(PApplet p) {
		applet = p;

		applet.registerMethod("pre", this);
		applet.registerMethod("draw", this);

	}

	public void pre() {
		for (Color c : channels) {
			c.beginDraw();
		}
	}

	public void draw() {
		for (Color c : channels) {
			c.endDraw();
		}
	}

	public Color add(String channelColor) {
		channelColor = channelColor.toUpperCase();
		if (!RISOCOLORS.containsKey(channelColor)) {
			throw new IllegalArgumentException("Color not found.");
		}
		int color = RISOCOLORS.get(channelColor);
		Color c = add(color, channelColor, applet.width, applet.height);
		return c;
	}

	public Color add(String channelColor, int w, int h) {
		channelColor = channelColor.toUpperCase();
		if (!RISOCOLORS.containsKey(channelColor)) {
			throw new IllegalArgumentException("Color not found.");
		}
		int color = RISOCOLORS.get(channelColor);
		Color c = add(color, channelColor, w, h);
		return c;
	}

	public Color add(int channelColor) {
		Color c = add(channelColor, "", applet.width, applet.height);
		return c;
	}

	public Color add(int channelColor, String channelName, int w, int h) {
		int channelIndex = channels.size();

		if (channelName == "")
			channelName = String.valueOf(channelIndex);

		Color c = new Color(applet, channelColor, w, h);

		c.channelIndex = channelIndex;
		c.channelName = channelName;

		channels.add(c);

		return c;
	}

	public void clear() {
		for (Color r : channels) {
			r.clear();
		}
	}

	public void preview() {
		applet.blendMode(MULTIPLY);
		for (Color r : channels) {
			r.draw();
		}
		applet.blendMode(BLEND);
	}

	public void print() {
		for (Color r : channels) {
			r.export();
		}
	}

	public int[] rgb2cmyk(int r, int g, int b) {
		// adapted from https://mrtan.me/post/java-rgb-to-cmyk-converter.html
		// or https://www.rapidtables.com/convert/color/rgb-to-cmyk.html

		double _r = r / 255.0d;
		double _g = g / 255.0d;
		double _b = b / 255.0d;

		double k = Math.min(Math.min(1d - _r, 1d - _g), 1d - _b);

		double c = 1.0d - (1.0d - _r - k) / (1.0d - k);
		double m = 1.0d - (1.0d - _g - k) / (1.0d - k);
		double y = 1.0d - (1.0d - _b - k) / (1.0d - k);

		k = 1.0d - k;

		return new int[] { (int) (c * 255), (int) (m * 255), (int) (y * 255), (int) (k * 255) };
	}

	public PImage extractCMYKChannel(PImage img, String c) {
		// multichannel extraction courtesy of Robin Sloan

		c = c.toLowerCase();

		PImage out = applet.createImage(img.width, img.height, ARGB);
		img.loadPixels();

		out.loadPixels();

		ArrayList<Integer> desiredChannels = new ArrayList<Integer>();

		if (c == "cyan" || c.contains("c"))
			desiredChannels.add(0);
		if (c == "magenta" || c.contains("m"))
			desiredChannels.add(1);
		if (c == "yellow" || c.contains("y"))
			desiredChannels.add(2);
		if (c == "black" || c.contains("k"))
			desiredChannels.add(3);

		for (int i = 0; i < img.pixels.length; i++) {
			int a = (img.pixels[i] >> 24) & 0xFF;
			int[] cmyk = rgb2cmyk((img.pixels[i] >> 16) & 0xFF, (img.pixels[i] >> 8) & 0xFF, img.pixels[i] & 0xFF);
			int val = 0;
			for (int desiredChannel : desiredChannels) {
				val += cmyk[desiredChannel];
			}
			val /= desiredChannels.size();
			out.pixels[i] = a << 24 | val << 16 | val << 8 | val;
		}

		out.updatePixels();

		return out;
	}

	public PImage extractRGBChannel(PImage img, String c) {
		c = c.toLowerCase();

		PImage out = applet.createImage(img.width, img.height, ARGB);
		img.loadPixels();

		out.loadPixels();

		int v = 0;

		for (int i = 0; i < img.pixels.length; i++) {
			int a = img.pixels[i] >> 24 & 0xFF;

			if (c == "r" || c == "red") {
				v = img.pixels[i] >> 16 & 0xFF;
			} else if (c == "g" || c == "green") {
				v = img.pixels[i] >> 8 & 0xFF;
			} else if (c == "b" || c == "blue") {
				v = img.pixels[i] & 0xFF;
			}

			out.pixels[i] = a << 24 | v << 16 | v << 8 | v;
		}

		out.updatePixels();

		return out;
	}

	public PImage threshold(PImage img, int thresh) {
		PImage out = applet.createImage(img.width, img.height, ARGB);
		out.loadPixels();

		img.loadPixels();

		for (int i = 0; i < out.pixels.length; i++) {
			// double avg = (applet.red(img.pixels[i]) + applet.green(img.pixels[i]) +
			// applet.blue(img.pixels[i])) / 3.0;
			float avg = applet.brightness(img.pixels[i]);
			out.pixels[i] = applet.color(avg < thresh ? 0 : 255);
		}

		out.updatePixels();
		return out;
	}

	public PImage halftone(PImage img, String shape) {
		return halftone(img, shape, 5, 0, 128);
	}

	public PImage halftone(PImage img, String shape, int frequency) {
		return halftone(img, shape, frequency, 0, 128);
	}

	public PImage halftone(PImage img, String shape, int frequency, float angle) {
		return halftone(img, shape, frequency, angle, 128);
	}

	public PImage halftone(PImage img, String shape, int frequency, float angle, int thresh) {

		img.loadPixels();

		int w = img.width;
		int h = img.height;

		PGraphics rotatedCanvas = applet.createGraphics(w * 2, h * 2, JAVA2D);

		rotatedCanvas.beginDraw();
		rotatedCanvas.background(255);
		rotatedCanvas.imageMode(CENTER);
		rotatedCanvas.pushMatrix();
		rotatedCanvas.translate(w, h);
		rotatedCanvas.rotate(-angle);
		rotatedCanvas.image(img, 0, 0);
		rotatedCanvas.popMatrix();
		rotatedCanvas.endDraw();
		rotatedCanvas.loadPixels();

		PGraphics out = applet.createGraphics(w * 2, h * 2, JAVA2D);
		out.beginDraw();
		out.background(255);
		out.ellipseMode(CORNER);
		out.rectMode(CENTER);
		out.fill(0);
		out.noStroke();

		int gridsize = frequency;

		for (int x = 0; x < rotatedCanvas.width; x += gridsize) {
			for (int y = 0; y < rotatedCanvas.height; y += gridsize) {
				int pxl = rotatedCanvas.pixels[(x + y * rotatedCanvas.width)];
				float avg = applet.brightness(pxl);
				if (avg < 255) {
					float darkness = (255.0f - avg) / 255.0f;

					if (shape == "circle") {
						out.ellipse(x, y, gridsize * darkness, gridsize * darkness);
					} else if (shape == "line") {
						out.rect(x, y, gridsize, gridsize * darkness);
					} else if (shape == "square") {
						out.rect(x, y, gridsize * darkness, gridsize * darkness);
					}
				}
			}
		}

		out.endDraw();

		rotatedCanvas.beginDraw();
		rotatedCanvas.background(255);
		rotatedCanvas.push();
		rotatedCanvas.translate(w, h);
		rotatedCanvas.rotate(angle);
		rotatedCanvas.image(out, 0, 0);
		rotatedCanvas.pop();
		rotatedCanvas.endDraw();

		PImage result = rotatedCanvas.get(w / 2, h / 2, w, h);
		return threshold(result, thresh);
	}

	public PImage dither(PImage img, String type, int threshold) {
		PImage out = applet.createImage(img.width, img.height, ARGB);
		out.loadPixels();

		img.loadPixels();

		// source adapted from:
		// https://github.com/meemoo/meemooapp/blob/44236a29574812026407c0288ab15390e88b556a/src/nodes/image-monochrome-worker.js

		int w = out.width;
		int newPixel, err;

		int[][] bayerThresholdMap = { { 15, 135, 45, 165 }, { 195, 75, 225, 105 }, { 60, 180, 30, 150 },
				{ 240, 120, 210, 90 } };

		double lumR[] = new double[256];
		double lumG[] = new double[256];
		double lumB[] = new double[256];

		for (int i = 0; i < 256; i++) {
			lumR[i] = (double) i * 0.299;
			lumG[i] = (double) i * 0.587;
			lumB[i] = (double) i * 0.114;
		}

		for (int i = 0; i < out.pixels.length; i++) {
			int r = (int) applet.red(out.pixels[i]);
			int g = (int) applet.blue(out.pixels[i]);
			int b = (int) applet.green(out.pixels[i]);
			int sum = (int) (lumR[r] + lumG[g] + lumB[b]);
			out.pixels[i] = applet.color(sum);
		}

		for (int i = 0; i < out.pixels.length; i++) {

			if (type == "none") {
				// No dithering
				out.pixels[i] = applet.red(out.pixels[i]) < threshold ? applet.color(0) : applet.color(255);
			} else if (type == "bayer") {
				// 4x4 Bayer ordered dithering algorithm
				int x = i / 4 % w;
				int y = (i / w);
				int map = ((out.pixels[i] + bayerThresholdMap[x % 4][y % 4]) / 2);
				out.pixels[i] = map < threshold ? applet.color(0) : applet.color(255);
			} else if (type == "floydsteinberg") {
				// Floyd–Steinberg dithering algorithm
				newPixel = out.pixels[i] < 129 ? 0 : 255;
				err = ((out.pixels[i] - newPixel) / 16);
				out.pixels[i] = applet.color(newPixel);
				out.pixels[i + 1] += err * 7;
				out.pixels[i + 1 * w - 1] += err * 3;
				out.pixels[i + 1 * w] += err * 5;
				out.pixels[i + 1 * w + 1] += err * 1;
			} else {
				// Bill Atkinson's dithering algorithm
				newPixel = out.pixels[i] < 129 ? 0 : 255;
				err = ((out.pixels[i] - newPixel) / 8);
				out.pixels[i] = newPixel;

				out.pixels[i + 1] += err;
				out.pixels[i + 2] += err;
				out.pixels[i + 1 * w - 1] += err;
				out.pixels[i + 1 * w] += err;
				out.pixels[i + 1 * w + 1] += err;
				out.pixels[i + 2 * w] += err;
			}

			// Set g and b pixels equal to r
			// out.pixels[i + 1] = out.pixels[i + 2] = out.pixels[i];
		}
		out.updatePixels();
		return out;
	}

	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

}
