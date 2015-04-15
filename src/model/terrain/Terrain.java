package model.terrain;

import java.awt.Color;

public abstract class Terrain{ 

	public abstract void accept(TerrainVisitor visitor);
	public abstract Color getColor();
}
