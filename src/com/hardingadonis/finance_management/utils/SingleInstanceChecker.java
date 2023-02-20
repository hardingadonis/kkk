/*
 * The MIT License
 *
 * Copyright (c) 2023 Minh Vương.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.hardingadonis.finance_management.utils;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Minh Vương
 */
public class SingleInstanceChecker {

    private static final String LOCK_FILE_NAME = "finance-management.hardingadonis.com.lock";
    private final File lockFile;

    public SingleInstanceChecker() {
        String userHome = System.getProperty("user.home");

        this.lockFile = new File(userHome, LOCK_FILE_NAME);
    }

    public boolean isAnotherRunning() {
        try {
            if (this.lockFile.createNewFile()) {
                return false;
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public boolean releaseLock() {
        return this.lockFile.delete();
    }
}
