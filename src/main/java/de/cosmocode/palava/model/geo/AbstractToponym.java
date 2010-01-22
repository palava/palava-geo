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

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import de.cosmocode.json.JSONRenderer;

/**
 * Abstract base implementation of the {@link ToponymBase} interface.
 * 
 * @author Willi Schoenborn
 */
@MappedSuperclass
public abstract class AbstractToponym implements ToponymBase {
    
    @Id
    private long id;

    private String name;

    @Column(name = "country_code")
    private String countryCode;

    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public JSONRenderer renderAsMap(JSONRenderer renderer) {
        return renderer.
            key("id").value(getId()).
            key("name").value(getName()).
            key("countryCode").value(getCountryCode()).
            key("aliases").array(getAliases());
    }
}
