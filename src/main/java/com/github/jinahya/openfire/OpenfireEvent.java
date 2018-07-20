/*
 * Copyright 2018 Jin Kwon &lt;onacit at gmail.com&gt;.
 *
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
 */
package com.github.jinahya.openfire;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public abstract class OpenfireEvent {

    // ------------------------------------------------------- currentTimeMillis
    public long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    public void setCurrentTimeMillis(final long currentTimeMillis) {
        this.currentTimeMillis = currentTimeMillis;
    }

    // ----------------------------------------------------------------- created
    public long getNanoTime() {
        return nanoTime;
    }

    public void setNanoTime(final long nanoTime) {
        this.nanoTime = nanoTime;
    }

    // -------------------------------------------------------------------------
    private long currentTimeMillis = System.currentTimeMillis();

    private long nanoTime = System.nanoTime();
}
