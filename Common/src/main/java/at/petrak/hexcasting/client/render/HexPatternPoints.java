package at.petrak.hexcasting.client.render;

import java.util.List;
import net.minecraft.world.phys.Vec2;

public class HexPatternPoints {
	public List<Vec2> zappyPoints = null;
	public String pointsKey =
			null; // TODO: if a string key isnt performant enough override hashcode for points

	public HexPatternPoints(List<Vec2> zappyPoints) {
		this.zappyPoints = zappyPoints;
		pointsKey = PatternTextureManager.getPointsKey(zappyPoints);
	}
}
