package org.ojug.mockito;

public class PlantWaterer {

    private final WaterSource waterSource;
    private final WateringScheduler wateringScheduler;

    public PlantWaterer(WaterSource waterSource, WateringScheduler wateringScheduler) {
        this.waterSource = waterSource;
        this.wateringScheduler = wateringScheduler;
    }

    public WaterSource getWaterSource() {
        return this.waterSource;
    }

    public WateringScheduler getWateringScheduler() {
        return this.wateringScheduler;
    }

}
