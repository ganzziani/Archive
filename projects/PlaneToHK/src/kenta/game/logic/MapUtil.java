package kenta.game.logic;

import net.phys2d.raw.Body;
import net.phys2d.raw.StaticBody;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.Box;
import org.newdawn.slick.tiled.TiledMap;

public class MapUtil {

    protected TiledMap map;
    protected World world;
    protected int mapWidth;
    protected int mapHeight;

    /**
     * Create a MapUtilI
     *
     * @param map The TiledMap to build a physical world of.
     * @param world The Phys2D World to build.
     */
    public MapUtil(TiledMap map, World world) {
        this.map = map;
        this.world = world;
        mapWidth = map.getWidth() * map.getTileWidth();
        mapHeight = map.getHeight() * map.getTileHeight();
        buildMap();
    }

    /**
     * Check to see if a foreground tile is found at location (x,y)
     *
     * @param x The location along the x-plane.
     * @param y The location along the y-plane.
     * @return True if there is a foreground tile at that location.
     */
    public boolean isForegroundAtLocation(int x, int y) {
        x = x / map.getTileWidth();
        y = y / map.getTileHeight();
        return (map.getTileImage(x, y, map.getLayerIndex("FOREGROUND")) == null) ? false
                : true;
    }

    /**
     * Check to see if a certain type (FOREGROUND, BACKGROUND, PLATFORMS) tile is found at location (x,y)
     *
     * @param x The location along the x-plane.
     * @param y The location along the y-plane.
     * @return True if there is a foreground tile at that location.
     */
    public boolean isTileTypeAt(int x, int y, String type) {
        boolean result = false;
        try {
            x = x / map.getTileWidth();
            y = y / map.getTileHeight();
            result = (map.getTileImage(x, y, map.getLayerIndex(type)) == null) ? false : true;
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * Check to see if the tile at location (x,y) is part of the foreground.
     *
     * @param x The location along the x-plane.
     * @param y The location along the y-plane.
     * @return True if the tile is part of the foreground.
     */
    public boolean isForegroundAtTile(int x, int y) {
        return (map.getTileImage(x, y, map.getLayerIndex("FOREGROUND")) == null) ? false
                : true;
    }

    /**
     * Read the TiledMap properties and build the physical world.
     */
    public void buildMap() {
        int tilesWide = map.getWidth();
        int tilesHigh = map.getHeight();
        int tileWidth = map.getTileWidth();
        int tileHeight = map.getTileHeight();

        for (int y = 0; y < tilesHigh; y++) {

            for (int x = 0; x < tilesWide; x++) {

                int localWidth = 0;
                int localX = 0;
                boolean adding = false;

                if (map.getTileImage(x, y, map.getLayerIndex("PLATFORMS")) != null) {

                    if (!adding) {
                        localX = x;
                        localWidth += tileWidth;
                        adding = true;
                    }

                    while ((x + 1) < tilesWide
                            && map.getTileImage(x + 1, y, map.getLayerIndex("PLATFORMS")) != null) {
                        localWidth += tileWidth;
                        x++;
                    }

                    Body body = new StaticBody("StaticBody_" + x + "_" + y,
                            new Box(localWidth, tileHeight));
                    body.setFriction(1f);
                    body.setRestitution(1f);
                    body.setPosition((localX * tileWidth + (localWidth / 2)),
                            (y * tileHeight + (tileHeight / 2)));
                    world.add(body);
                }
            }
        }
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }
}
