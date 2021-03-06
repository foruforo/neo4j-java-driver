/**
 * Copyright (c) 2002-2015 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.driver.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.neo4j.driver.Value;
import org.neo4j.driver.exceptions.value.NotMultiValued;

import static org.neo4j.driver.internal.Identities.identity;
import static org.neo4j.driver.Values.value;

public class NotMultiValuedTest
{
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void identityValueIsNotIndexedCollection() throws Throwable
    {
        // Given
        Value id = value( identity( "node/1" ) );

        // Expect
        exception.expect( NotMultiValued.class );
        exception.expectMessage( "identity is not an indexed collection" );

        // When
        id.get( 0 );
    }

    @Test
    public void identityValueIsNotKeyedCollection() throws Throwable
    {
        // Given
        Value id = value( identity( "node/1" ) );

        // Expect
        exception.expect( NotMultiValued.class );
        exception.expectMessage( "identity is not a keyed collection" );

        // When
        id.get( "" );
    }

    @Test
    public void identityValueIsNotIterable() throws Throwable
    {
        // Given
        Value id = value( identity( "node/1" ) );

        // Expect
        exception.expect( NotMultiValued.class );
        exception.expectMessage( "identity is not iterable" );

        // When
        id.iterator();
    }

}