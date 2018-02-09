package online.c3iot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C3IoTMainClass {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		String fileName = "src/online/c3iot/input.txt";
		try {
			// Read file using FileReader and BufferedReader
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// first input is boardDimension
			String[] dimensionArray = bufferedReader.readLine().trim().split(" ");
			Pair boardDimension = new Pair(Integer.parseInt(dimensionArray[0].trim()),
					Integer.parseInt(dimensionArray[1].trim()));

			// second input is initialPosition
			String[] initPositionArray = bufferedReader.readLine().trim().split(" ");
			Pair initialPosition = new Pair(Integer.parseInt(initPositionArray[0].trim()),
					Integer.parseInt(initPositionArray[1].trim()));

			// third input is movementString
			String movementString = bufferedReader.readLine().trim().toUpperCase();

			// final input is list of walls as pairs
			List<Pair> walls = new ArrayList<Pair>();
			String line = null;
			while((line = bufferedReader.readLine()) != null) {
				String[] wallLocationArray = line.split(" ");
				Pair wallLocation = new Pair(Integer.parseInt(wallLocationArray[0].trim()),
						Integer.parseInt(wallLocationArray[1].trim()));
				walls.add(wallLocation);
			}

			Solution ins = new Solution(boardDimension, initialPosition, movementString, walls);

			System.out.println();
			System.out.println("Location = (" + ins.getFinalLocation().x + " " + ins.getFinalLocation().y + ')');
			System.out.println("Coins = " + ins.getTotalCoinsCollected());
			System.out.println();
			
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);

	}

}
