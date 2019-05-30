/*
 * Copyright (c) 2015-2018 MICROTRUST Incorporated
 * All rights reserved
 *
 * This file and software is confidential and proprietary to MICROTRUST Inc.
 * Unauthorized copying of this file and software is strictly prohibited.
 * You MUST NOT disclose this file and software unless you get a license
 * agreement from MICROTRUST Incorporated.
 */

package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;

public class SoterExportResult implements Parcelable {

    public int resultCode;
    public byte[] exportData;
    public int exportDataLength;

    public SoterExportResult(){
        super();
    }


    public SoterExportResult(Parcel in) {
        resultCode = in.readInt();
        exportData = in.createByteArray();
        exportDataLength = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(resultCode);
        dest.writeByteArray(exportData);
        dest.writeInt(exportDataLength);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SoterExportResult> CREATOR = new Creator<SoterExportResult>() {
        @Override
        public SoterExportResult createFromParcel(Parcel in) {
            return new SoterExportResult(in);
        }

        @Override
        public SoterExportResult[] newArray(int size) {
            return new SoterExportResult[size];
        }
    };
}