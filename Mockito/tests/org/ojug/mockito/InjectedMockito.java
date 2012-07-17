package org.ojug.mockito;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class InjectedMockito {

    @Mock
    private WaterSource mockWaterSource;

    @Mock
    private WateringScheduler mockWateringScheduler;

    @InjectMocks
    private PlantWaterer plantWaterer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldInjectMocks() {
        assertNotNull(this.plantWaterer);
        assertNotNull(this.plantWaterer.getWaterSource());
        assertNotNull(this.plantWaterer.getWateringScheduler());
    }

}
