/**
 * palava - a java-php-bridge
 * Copyright (C) 2007  CosmoCode GmbH
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package de.cosmocode.palava.model.geo;

import java.util.TimeZone;

import org.geonames.FeatureClass;

import com.google.common.collect.ImmutableList;

import de.cosmocode.palava.model.base.EntityBase;
import de.cosmocode.palava.model.business.Geographical;

/**
 * Read only!
 * 
 * @see <a href="http://download.geonames.org/export/dump/">Geonames.org Download Server</a>
 * 
 * @author Willi Schoenborn
 */
public interface ToponymBase extends EntityBase, Geographical {
    
    String getName();
    
    // TODO asciialize
    String getAsciiName();
    
    ImmutableList<String> getAlternateNames();
    
    FeatureClass getFeatureClass();
    
    String getFeatureCode();
    
    String getCountryCode();
    
    ImmutableList<String> getAlternateCountryCodes();
    
    String getFirstDivision();

    String getSecondDivision();

    String getThirdDivision();

    String getFourthDivision();
    
    Long getPopulation();
    
    Integer getElevation();
    
    Integer getAverageElevation();
    
    TimeZone getTimeZone();
    
}
