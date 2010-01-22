package de.cosmocode.palava.model.geo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import de.cosmocode.json.JSONRenderer;
import de.cosmocode.palava.model.base.AbstractEntity;
import de.cosmocode.palava.model.business.AbstractLocation;
import de.cosmocode.palava.model.business.LocationBase;

/**
 * Abstract base implementation of the {@link AirportBase} interface.
 *
 * @author Willi Schoenborn
 */
@MappedSuperclass
public abstract class AbstractAirport extends AbstractEntity implements AirportBase {

    @Column(name = "airport_code")
    private String airportCode;
    
    private String name;
    
    @Column(name = "city_name")
    private String cityName;
    
    @Column(name = "country_name")
    private String countryName;
    
    @Column(name = "country_code")
    private String countryCode;
    
    @Column(name = "world_area_code")
    private String worldAreaCode;

    private Double latitude;
    
    private Double longitude;
    
    @Override
    public String getAirportCode() {
        return airportCode;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getCityName() {
        return cityName;
    }
    
    @Override
    public String getCountryName() {
        return countryName;
    }
    
    @Override
    public String getCountryCode() {
        return countryCode;
    }
    
    @Override
    public String getWorldAreaCode() {
        return worldAreaCode;
    }
    
    @Override
    public LocationBase getLocation() {
        return new InternalLocation();
    }
    
    /**
     * 
     *
     * @author Willi Schoenborn
     */
    private final class InternalLocation extends AbstractLocation {
        
        @Override
        public Double getLatitude() {
            return latitude;
        }
        
        @Override
        public void setLatitude(Double latitude) {
            AbstractAirport.this.latitude = latitude;
        }
        
        @Override
        public Double getLongitude() {
            return longitude;
        }
        
        @Override
        public void setLongitude(Double longitude) {
            AbstractAirport.this.longitude = longitude;
        }
        
    }
    
    @Override
    public JSONRenderer renderAsMap(JSONRenderer renderer) {
        return
            super.renderAsMap(renderer).
            key("airportCode").value(getAirportCode()).
            key("name").value(getName()).
            key("cityName").value(getCityName()).
            key("countryName").value(getCountryName()).
            key("countryCode").value(getCountryCode()).
            key("worldAreaCode").value(getWorldAreaCode());
    }

}
