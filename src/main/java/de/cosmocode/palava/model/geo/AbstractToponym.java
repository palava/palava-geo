package de.cosmocode.palava.model.geo;

import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.geonames.FeatureClass;

import com.google.common.collect.ImmutableList;

import de.cosmocode.palava.model.base.AbstractEntity;
import de.cosmocode.palava.model.business.AbstractLocation;
import de.cosmocode.palava.model.business.LocationBase;

public abstract class AbstractToponym extends AbstractEntity implements ToponymBase {

    private String name;
    
    @Column(name = "ascii_name")
    private String asciiName;
    
    @Column(name = "alternate_names")
    private String alternateNames;
    
    @Transient
    private transient ImmutableList<String> alternateNamesList;
    
    @Column(name = "feature_class")
    private FeatureClass featureClass;
    
    @Column(name = "feature_code")
    private String featureCode;
    
    @Column(name = "country_code")
    private String countryCode;
    
    @Column(name = "alternate_country_codes")
    private String alternateCountryCodes;
    
    @Transient
    private transient ImmutableList<String> alternateCountryCodesList;
    
    @Column(name = "first_division")
    private String firstDivision;
    
    @Column(name = "second_division")
    private String secondDivision;
    
    @Column(name = "third_division")
    private String thirdDivision;
    
    @Column(name = "fourth_division")
    private String fourthDivision;
    
    private Long population;
    
    private Integer elevation;
    
    @Column(name = "average_elevation")
    private Integer averageElevation;
    
    @Column(name = "time_zone")
    private String timeZone;

    private Double latitude;
    
    private Double longitude;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAsciiName() {
        return asciiName;
    }
    
    @Override
    public ImmutableList<String> getAlternateNames() {
        if (alternateNamesList == null) {
            if (StringUtils.isBlank(alternateNames)) {
                alternateNamesList = ImmutableList.of();
            } else {
                alternateNamesList = ImmutableList.of(alternateNames.split(","));
            }
        }
        return alternateNamesList;
    }
    
    @Override
    public FeatureClass getFeatureClass() {
        return featureClass;
    }
    
    @Override
    public String getFeatureCode() {
        return featureCode;
    }
    
    @Override
    public String getCountryCode() {
        return countryCode;
    }
    
    @Override
    public ImmutableList<String> getAlternateCountryCodes() {
        if (alternateCountryCodesList == null) {
            if (StringUtils.isBlank(alternateCountryCodes)) {
                alternateCountryCodesList = ImmutableList.of();
            } else {
                alternateCountryCodesList = ImmutableList.of(alternateCountryCodes.split(","));
            }
        }
        return alternateCountryCodesList;
    }
    
    @Override
    public String getFirstDivision() {
        return firstDivision;
    }
    
    @Override
    public String getSecondDivision() {
        return secondDivision;
    }
    
    @Override
    public String getThirdDivision() {
        return thirdDivision;
    }
    
    @Override
    public String getFourthDivision() {
        return fourthDivision;
    }
    
    @Override
    public Long getPopulation() {
        return population;
    }
    
    @Override
    public Integer getElevation() {
        return elevation;
    }
    
    @Override
    public Integer getAverageElevation() {
        return averageElevation;
    }
    
    @Override
    public TimeZone getTimeZone() {
        return StringUtils.isBlank(timeZone) ? null : TimeZone.getTimeZone(timeZone);
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
            AbstractToponym.this.latitude = latitude;
        }
        
        @Override
        public Double getLongitude() {
            return longitude;
        }
        
        @Override
        public void setLongitude(Double longitude) {
            AbstractToponym.this.longitude = longitude;
        }
        
    }

}
