/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.metastorage;

import org.apache.ignite.internal.metastorage.exceptions.CompactedException;
import org.apache.ignite.internal.tostring.S;

/** Information about metastorage revisions. */
public class Revisions {
    private final long revision;

    private final long compactionRevision;

    /**
     * Constructor.
     *
     * @param revision Metastorage revision.
     * @param compactionRevision Metastorage compaction revision.
     */
    public Revisions(long revision, long compactionRevision) {
        this.revision = revision;
        this.compactionRevision = compactionRevision;
    }

    /** Returns metastorage revision. */
    public long revision() {
        return revision;
    }

    /**
     * Returns metastorage compaction revision of the up to which (inclusive) key versions will be deleted and when trying to read them,
     * {@link CompactedException} will occur.
     */
    public long compactionRevision() {
        return compactionRevision;
    }

    @Override
    public String toString() {
        return S.toString(this);
    }
}