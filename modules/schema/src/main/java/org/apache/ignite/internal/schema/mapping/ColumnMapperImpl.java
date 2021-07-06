/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.schema.mapping;

import org.apache.ignite.internal.schema.Column;
import org.apache.ignite.internal.schema.SchemaDescriptor;

/**
 * Column mapper implementation.
 */
class ColumnMapperImpl implements ColumnMapper, ColumnaMapperBuilder {
    /** Mapping. */
    private final int[] mapping;

    /** Mapped columns. */
    private final Column[] cols;

    /**
     * @param schema Schema descriptor.
     */
    ColumnMapperImpl(SchemaDescriptor schema) {
        mapping = new int[schema.length()];
        cols = new Column[schema.length()];

        for (int i = 0; i < mapping.length; i++) {
            mapping[i] = i;
            cols[i] = schema.column(i);
        }
    }

    /** {@inheritDoc} */
    @Override public void add(int from, int to, Column col) {
        mapping[from] = to;
        cols[from] = col;
    }

    /** {@inheritDoc} */
    @Override public int map(int idx) {
        if (idx > mapping.length)
            return -1;

        return mapping[idx];
    }

    /** {@inheritDoc} */
    @Override public Column mappedColumn(int idx) {
        return cols[idx];
    }

    /** {@inheritDoc} */
    @Override public ColumnMapper build() {
        return this;
    }
}
