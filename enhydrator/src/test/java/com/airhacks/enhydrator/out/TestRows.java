package com.airhacks.enhydrator.out;

/*
 * #%L
 * enhydrator
 * %%
 * Copyright (C) 2014 Adam Bien
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import com.airhacks.enhydrator.in.Row;

/**
 *
 * @author airhacks.com
 */
public class TestRows {

    public static Row getStringRow() {
        Row row = new Row();
        row.addColumn(0, "a", "java");
        row.addColumn(1, "b", "tengah");
        return row;
    }

    public static Row getIntRow() {
        Row row = new Row();
        row.addColumn(0, "a", "1");
        row.addColumn(1, "b", "2");
        return row;
    }
}