package palantir.online;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.URISyntaxException;
import java.util.StringTokenizer;

/**
 * 
 * @author SUN LEI
 */
public class LeiLei2013 {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static int size = 0;
	public static int cur_level = -1;

	public static void main(String[] args) throws IOException,
			URISyntaxException {

		String inputFile;

		// this code got bug - cannot execute properly for 2nd test
		for (int testCaseNumber = 0; testCaseNumber < 5; testCaseNumber++) {
			inputFile = "input" + testCaseNumber + ".txt";
			FileReader jin = new FileReader(new File(LeiLei2013.class
					.getResource(inputFile).toURI()));
			BufferedReader reader = new BufferedReader(jin);

			size = Integer.parseInt(reader.readLine());
			int[][] plot = new int[size][size];
			int[][] basin = new int[size][size];
			for (int i = 0; i < size; i++) {
				String s = reader.readLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				for (int j = 0; j < size; j++) {
					plot[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					basin[i][j] = -1;
				}
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (isSink(i, j, plot)) {
						basin[i][j] = cur_level + 1;
						cur_level++;
					}
				}
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (basin[i][j] == -1) {
						label(i, j, plot, basin);
					}
				}
			}
			// System.out.println(cur_level);
			for (int level = 0; level < cur_level + 1; level++) {
				int count = 0;
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (level == basin[i][j])
							count++;
					}
				}
				if (level != cur_level)
					System.out.print(count + " ");
				else
					System.out.print(count);
			}
			System.out.println();
		}
	}

	public static boolean isSink(int i, int j, int[][] plot) {
		int location = -1;//
		if (i > 0 && i < size - 1) {
			if (j > 0 && j < size - 1) {
				location = 8;
				if (plot[i - 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i][j + 1] < plot[i][j]) {
					return false;
				}
				if (plot[i][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i - 1][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i - 1][j + 1] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j + 1] < plot[i][j]) {
					return false;
				}
			} else if (j == 0) {
				location = 7;
				if (plot[i - 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i][j + 1] < plot[i][j]) {
					return false;
				}
				if (plot[i - 1][j + 1] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j + 1] < plot[i][j]) {
					return false;
				}
			} else if (j == size - 1) {
				location = 3;
				if (plot[i - 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i - 1][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j - 1] < plot[i][j]) {
					return false;
				}
			}
		} else if (i == 0) {
			if (j > 0 && j < size - 1) {
				location = 1;
				if (plot[i + 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i][j + 1] < plot[i][j]) {
					return false;
				}
				if (plot[i][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j + 1] < plot[i][j]) {
					return false;
				}
			} else if (j == 0) {
				location = 0;
				if (plot[i + 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i][j + 1] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j + 1] < plot[i][j]) {
					return false;
				}
			} else if (j == size - 1) {
				location = 2;
				if (plot[i + 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i + 1][j - 1] < plot[i][j]) {
					return false;
				}
				;
			}
		} else if (i == size - 1) {
			if (j > 0 && j < size - 1) {
				if (plot[i - 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i][j + 1] < plot[i][j]) {
					return false;
				}
				if (plot[i][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i - 1][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i - 1][j + 1] < plot[i][j]) {
					return false;
				}
			} else if (j == 0) {
				location = 6;
				if (plot[i - 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i][j + 1] < plot[i][j]) {
					return false;
				}
				if (plot[i - 1][j + 1] < plot[i][j]) {
					return false;
				}
			} else if (j == size - 1) {
				location = 4;
				if (plot[i - 1][j] < plot[i][j]) {
					return false;
				}
				if (plot[i][j - 1] < plot[i][j]) {
					return false;
				}
				if (plot[i - 1][j - 1] < plot[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void labelNei(int i, int j, int[][] basin) {
		int location = -1;
		if (i > 0 && i < size - 1) {
			if (j > 0 && j < size - 1) {
				location = 8;
				basin[i - 1][j] = basin[i][j];
				basin[i + 1][j] = basin[i][j];
				basin[i - 1][j + 1] = basin[i][j];
				basin[i][j - 1] = basin[i][j];
				basin[i - 1][j - 1] = basin[i][j];
				basin[i][j + 1] = basin[i][j];
				basin[i + 1][j - 1] = basin[i][j];
				basin[i + 1][j + 1] = basin[i][j];
			} else if (j == 0) {
				location = 7;
				basin[i - 1][j] = basin[i][j];
				basin[i + 1][j] = basin[i][j];
				basin[i - 1][j + 1] = basin[i][j];
				basin[i][j + 1] = basin[i][j];
				basin[i + 1][j + 1] = basin[i][j];
			} else if (j == size - 1) {
				basin[i - 1][j] = basin[i][j];
				basin[i + 1][j] = basin[i][j];
				basin[i][j - 1] = basin[i][j];
				basin[i - 1][j - 1] = basin[i][j];
				basin[i + 1][j - 1] = basin[i][j];
			}
		} else if (i == 0) {
			if (j > 0 && j < size - 1) {
				location = 1;
				basin[i + 1][j] = basin[i][j];
				basin[i][j - 1] = basin[i][j];
				basin[i][j + 1] = basin[i][j];
				basin[i + 1][j - 1] = basin[i][j];
				basin[i + 1][j + 1] = basin[i][j];

			} else if (j == 0) {
				location = 0;
				basin[i + 1][j] = basin[i][j];
				basin[i][j + 1] = basin[i][j];
				basin[i + 1][j + 1] = basin[i][j];
			} else if (j == size - 1) {
				basin[i + 1][j] = basin[i][j];
				basin[i][j - 1] = basin[i][j];
				basin[i + 1][j - 1] = basin[i][j];
			}
		} else if (i == size - 1) {
			if (j > 0 && j < size - 1) {
				basin[i - 1][j] = basin[i][j];
				basin[i - 1][j + 1] = basin[i][j];
				basin[i][j - 1] = basin[i][j];
				basin[i - 1][j - 1] = basin[i][j];
				basin[i][j + 1] = basin[i][j];
			} else if (j == 0) {
				location = 6;
				basin[i - 1][j] = basin[i][j];
				basin[i - 1][j + 1] = basin[i][j];
				basin[i][j + 1] = basin[i][j];
			} else if (j == size - 1) {
				location = 4;
				basin[i - 1][j] = basin[i][j];
				basin[i][j - 1] = basin[i][j];
				basin[i - 1][j - 1] = basin[i][j];
			}
		}
	}

	public static int label(int i, int j, int[][] plot, int[][] basin) {
		int location = -1;
		int temp = 10000;
		int idx = -1;
		int jdx = -1;
		if (i > 0 && i < size - 1) {
			if (j > 0 && j < size - 1) {
				location = 8;
				if (temp > plot[i - 1][j]) {
					temp = plot[i - 1][j];
					idx = i - 1;
					jdx = j;
				}
				if (temp > plot[i - 1][j - 1]) {
					temp = plot[i - 1][j - 1];
					idx = i - 1;
					jdx = j - 1;
				}
				if (temp > plot[i - 1][j + 1]) {
					temp = plot[i - 1][j + 1];
					idx = i - 1;
					jdx = j + 1;
				}
				if (temp > plot[i + 1][j]) {
					temp = plot[i + 1][j];
					idx = i + 1;
					jdx = j;
				}
				if (temp > plot[i + 1][j - 1]) {
					temp = plot[i + 1][j - 1];
					idx = i + 1;
					jdx = j - 1;
				}
				if (temp > plot[i + 1][j + 1]) {
					temp = plot[i + 1][j + 1];
					idx = i + 1;
					jdx = j + 1;
				}
				if (temp > plot[i][j + 1]) {
					temp = plot[i][j + 1];
					idx = i;
					jdx = j + 1;
				}
				if (temp > plot[i][j - 1]) {
					temp = plot[i][j - 1];
					idx = i;
					jdx = j - 1;
				}
			} else if (j == 0) {
				location = 7;
				if (temp > plot[i - 1][j]) {
					temp = plot[i - 1][j];
					idx = i - 1;
					jdx = j;
				}
				if (temp > plot[i - 1][j + 1]) {
					temp = plot[i - 1][j + 1];
					idx = i - 1;
					jdx = j + 1;
				}
				if (temp > plot[i + 1][j]) {
					temp = plot[i + 1][j];
					idx = i + 1;
					jdx = j;
				}
				if (temp > plot[i + 1][j + 1]) {
					temp = plot[i + 1][j + 1];
					idx = i + 1;
					jdx = j + 1;
				}
				if (temp > plot[i][j + 1]) {
					temp = plot[i][j + 1];
					idx = i;
					jdx = j + 1;
				}
			} else if (j == size - 1) {
				if (temp > plot[i - 1][j]) {
					temp = plot[i - 1][j];
					idx = i - 1;
					jdx = j;
				}
				if (temp > plot[i - 1][j - 1]) {
					temp = plot[i - 1][j - 1];
					idx = i - 1;
					jdx = j - 1;
				}
				if (temp > plot[i + 1][j]) {
					temp = plot[i + 1][j];
					idx = i + 1;
					jdx = j;
				}
				if (temp > plot[i + 1][j - 1]) {
					temp = plot[i + 1][j - 1];
					idx = i + 1;
					jdx = j - 1;
				}
				if (temp > plot[i][j - 1]) {
					temp = plot[i][j - 1];
					idx = i;
					jdx = j - 1;
				}
			}
		} else if (i == 0) {
			if (j > 0 && j < size - 1) {
				if (temp > plot[i + 1][j]) {
					temp = plot[i + 1][j];
					idx = i + 1;
					jdx = j;
				}
				if (temp > plot[i + 1][j - 1]) {
					temp = plot[i + 1][j - 1];
					idx = i + 1;
					jdx = j - 1;
				}
				if (temp > plot[i + 1][j + 1]) {
					temp = plot[i + 1][j + 1];
					idx = i + 1;
					jdx = j + 1;
				}
				if (temp > plot[i][j + 1]) {
					temp = plot[i][j + 1];
					idx = i;
					jdx = j + 1;
				}
				if (temp > plot[i][j - 1]) {
					temp = plot[i][j - 1];
					idx = i;
					jdx = j - 1;
				}

			} else if (j == 0) {
				location = 0;
				if (temp > plot[i + 1][j]) {
					temp = plot[i + 1][j];
					idx = i + 1;
					jdx = j;
				}
				if (temp > plot[i + 1][j + 1]) {
					temp = plot[i + 1][j + 1];
					idx = i + 1;
					jdx = j + 1;
				}
				if (temp > plot[i][j + 1]) {
					temp = plot[i][j + 1];
					idx = i;
					jdx = j + 1;
				}
			} else if (j == size - 1) {
				if (temp > plot[i + 1][j]) {
					temp = plot[i + 1][j];
					idx = i + 1;
					jdx = j;
				}
				if (temp > plot[i + 1][j - 1]) {
					temp = plot[i + 1][j - 1];
					idx = i + 1;
					jdx = j - 1;
				}
				if (temp > plot[i][j - 1]) {
					temp = plot[i][j - 1];
					idx = i;
					jdx = j - 1;
				}
			}
		} else if (i == size - 1) {
			if (j > 0 && j < size - 1) {
				if (temp > plot[i - 1][j]) {
					temp = plot[i - 1][j];
					idx = i - 1;
					jdx = j;
				}
				if (temp > plot[i - 1][j - 1]) {
					temp = plot[i - 1][j - 1];
					idx = i - 1;
					jdx = j - 1;
				}
				if (temp > plot[i - 1][j + 1]) {
					temp = plot[i - 1][j + 1];
					idx = i - 1;
					jdx = j + 1;
				}
				if (temp > plot[i][j + 1]) {
					temp = plot[i][j + 1];
					idx = i;
					jdx = j + 1;
				}
				if (temp > plot[i][j - 1]) {
					temp = plot[i][j - 1];
					idx = i;
					jdx = j - 1;
				}
			} else if (j == 0) {
				location = 6;
				if (temp > plot[i - 1][j]) {
					temp = plot[i - 1][j];
					idx = i - 1;
					jdx = j;
				}
				if (temp > plot[i - 1][j + 1]) {
					temp = plot[i - 1][j + 1];
					idx = i - 1;
					jdx = j + 1;
				}
				if (temp > plot[i][j + 1]) {
					temp = plot[i][j + 1];
					idx = i;
					jdx = j + 1;
				}
			} else if (j == size - 1) {
				location = 4;
				if (temp > plot[i - 1][j]) {
					temp = plot[i - 1][j];
					idx = i - 1;
					jdx = j;
				}
				if (temp > plot[i - 1][j - 1]) {
					temp = plot[i - 1][j - 1];
					idx = i - 1;
					jdx = j - 1;
				}
				if (temp > plot[i][j - 1]) {
					temp = plot[i][j - 1];
					idx = i;
					jdx = j - 1;
				}
			}
		}
		if (basin[idx][jdx] != -1) {
			basin[i][j] = basin[idx][jdx];
		} else if (basin[idx][jdx] == -1) {
			/*
			 * if(isSink(idx,jdx,plot)){ basin[idx][jdx] = cur_level + 1;
			 * cur_level++; labelNei(i, j, basin); basin[i][j]=basin[idx][jdx];
			 * }else{ basin[i][j]=label(idx,jdx,plot,basin); }
			 */
			basin[i][j] = label(idx, jdx, plot, basin);
		}
		return basin[i][j];
	}
}
