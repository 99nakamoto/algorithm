package Question9_7;

import java.util.LinkedList;
import java.util.Queue;

public class MyAnswer {

	public static void PaintFill1(Color[][] screen, int posX, int posY,
			Color ncolor) {
		// the queue keeps the list of positions that I'm going to visit
		Queue<Position> q = new LinkedList<Position>();
		int len = screen.length;
		Color original = screen[posX][posY];
		// visited origin node first
		q.offer(new Position(posX, posY));
		while (!q.isEmpty()) {
			// visit positions in q one by one (mark color as 'Temp')
			Position p = q.poll();
			if (p.x < 0 || p.x >= len || p.y < 0 || p.y >= len) {
				// invalid pos coordinate
				continue;
			} else if (screen[p.x][p.y] == Color.Temp
					|| screen[p.x][p.y] != original) {
				continue;
			}
			screen[p.x][p.y] = Color.Temp;
			q.offer(new Position(p.x - 1, p.y));
			q.offer(new Position(p.x + 1, p.y));
			q.offer(new Position(p.x, p.y - 1));
			q.offer(new Position(p.x, p.y + 1));
		}
		// finish visiting all positions that's original color
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (screen[i][j] == Color.Temp) {
					screen[i][j] = ncolor;
				}
			}
		}
	}

	public static void PaintFill2(Color[][] screen, int posX, int posY,
			Color ncolor) {
		// the queue keeps the list of positions that I'm going to visit
		Queue<Position> q = new LinkedList<Position>();
		int len = screen.length;
		Color original = screen[posX][posY];
		// visited origin node first
		q.offer(new Position(posX, posY));
		while (!q.isEmpty()) {
			// visit positions in q one by one (mark color as 'Temp')
			Position p = q.poll();
			if (p.x < 0 || p.x >= len || p.y < 0 || p.y >= len) {
				// invalid pos coordinate
				continue;
			} else if (screen[p.x][p.y] != original) {
				continue;
			}
			screen[p.x][p.y] = ncolor;
			q.offer(new Position(p.x - 1, p.y));
			q.offer(new Position(p.x + 1, p.y));
			q.offer(new Position(p.x, p.y - 1));
			q.offer(new Position(p.x, p.y + 1));
		}
	}

	static class Position {
		int x;
		int y;

		public Position(int a, int b) {
			x = a;
			y = b;
		}
	}

}
