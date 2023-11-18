package com.calculator.datasizecalculator;

public class DataConverter {

    //For Bits
    public static double convertBitsToNibbles(double bits) {
        // 1 nibble = 4 bits
        return bits / 4;
    }

    public static double convertBitsToBytes(double bits) {
        // 1 byte = 8 bits
        return bits / 8;
    }

    public static double convertBitsToKiloBytes(double bits) {
        // 1 kilobyte (KB) = 1024 bytes
        return convertBitsToBytes(bits) / 1024;
    }

    public static double convertBitsToMegaBytes(double bits) {
        // 1 megabyte (MB) = 1024 kilobytes
        return convertBitsToKiloBytes(bits) / 1024;
    }

    public static double convertBitsToGigaBytes(double bits) {
        // 1 gigabyte (GB) = 1024 megabytes
        return convertBitsToMegaBytes(bits) / 1024;
    }

    public static double convertBitsToTeraBytes(double bits) {
        // 1 terabyte (TB) = 1024 gigabytes
        return convertBitsToGigaBytes(bits) / 1024;
    }


    //For Nibbles
    public static double convertNibblesToBits(double nibbles) {
        // 1 nibble = 4 bits
        return nibbles * 4;
    }

    public static double convertNibblesToBytes(double nibbles) {
        // 1 byte = 2 nibbles
        return nibbles / 2;
    }

    public static double convertNibblesToKiloBytes(double nibbles) {
        // 1 kilobyte (KB) = 1024 bytes
        return convertNibblesToBytes(nibbles) / 1024;
    }

    public static double convertNibblesToMegaBytes(double nibbles) {
        // 1 megabyte (MB) = 1024 kilobytes
        return convertNibblesToKiloBytes(nibbles) / 1024;
    }

    public static double convertNibblesToGigaBytes(double nibbles) {
        // 1 gigabyte (GB) = 1024 megabytes
        return convertNibblesToMegaBytes(nibbles) / 1024;
    }

    public static double convertNibblesToTeraBytes(double nibbles) {
        // 1 terabyte (TB) = 1024 gigabytes
        return convertNibblesToGigaBytes(nibbles) / 1024;
    }


    //For Bytes
    public static double convertBytesToBits(double bytes) {
        // 1 byte = 8 bits
        return bytes * 8;
    }

    public static double convertBytesToNibbles(double bytes) {
        // 1 byte = 2 nibbles
        return bytes * 2;
    }

    public static double convertBytesToKiloBytes(double bytes) {
        // 1 kilobyte (KB) = 1024 bytes
        return bytes / 1024;
    }

    public static double convertBytesToMegaBytes(double bytes) {
        // 1 megabyte (MB) = 1024 kilobytes
        return convertBytesToKiloBytes(bytes) / 1024;
    }

    public static double convertBytesToGigaBytes(double bytes) {
        // 1 gigabyte (GB) = 1024 megabytes
        return convertBytesToMegaBytes(bytes) / 1024;
    }

    public static double convertBytesToTeraBytes(double bytes) {
        // 1 terabyte (TB) = 1024 gigabytes
        return convertBytesToGigaBytes(bytes) / 1024;
    }


    //For KiloBytes
    public static double convertKiloBytesToBits(double kilobytes) {
        // 1 kilobyte (KB) = 1024 bytes
        return convertBytesToBits(kilobytes * 1024);
    }
    public static double convertKiloBytesToNibbles(double kilobytes) {
        // 1 kilobyte (KB) = 1024 bytes, 1 byte = 2 nibbles
        return convertKiloBytesToBytes(kilobytes) * 2;
    }
    public static double convertKiloBytesToBytes(double kilobytes) {
        // 1 kilobyte (KB) = 1024 bytes
        return kilobytes * 1024;
    }

    public static double convertKiloBytesToMegaBytes(double kilobytes) {
        // 1 megabyte (MB) = 1024 kilobytes
        return kilobytes / 1024;
    }

    public static double convertKiloBytesToGigaBytes(double kilobytes) {
        // 1 gigabyte (GB) = 1024 megabytes
        return convertKiloBytesToMegaBytes(kilobytes) / 1024;
    }

    public static double convertKiloBytesToTeraBytes(double kilobytes) {
        // 1 terabyte (TB) = 1024 gigabytes
        return convertKiloBytesToGigaBytes(kilobytes) / 1024;
    }


    //For GigaBytes
    public static double convertGigaBytesToBits(double gigabytes) {
        // 1 gigabyte (GB) = 1024 megabytes, 1 megabyte (MB) = 1024 kilobytes, 1 kilobyte (KB) = 1024 bytes, 1 byte = 8 bits
        return gigabytes * 1024 * 1024 * 1024 * 8;
    }

    public static double convertGigaBytesToNibbles(double gigabytes) {
        // 1 gigabyte (GB) = 1024 megabytes, 1 megabyte (MB) = 1024 kilobytes, 1 kilobyte (KB) = 1024 bytes, 1 byte = 2 nibbles
        return convertGigaBytesToBytes(gigabytes) * 2;
    }

    public static double convertGigaBytesToBytes(double gigabytes) {
        // 1 gigabyte (GB) = 1024 megabytes, 1 megabyte (MB) = 1024 kilobytes, 1 kilobyte (KB) = 1024 bytes
        return gigabytes * 1024 * 1024 * 1024;
    }

    public static double convertGigaBytesToKiloBytes(double gigabytes) {
        // 1 gigabyte (GB) = 1024 megabytes, 1 megabyte (MB) = 1024 kilobytes
        return gigabytes * 1024 * 1024;
    }

    public static double convertGigaBytesToMegaBytes(double gigabytes) {
        // 1 gigabyte (GB) = 1024 megabytes
        return gigabytes * 1024;
    }

    public static double convertGigaBytesToTeraBytes(double gigabytes) {
        // 1 terabyte (TB) = 1024 gigabytes
        return gigabytes / 1024;
    }


    //For MegaBytes
    public static double convertMegaBytesToBits(double megabytes) {
        // 1 megabyte (MB) = 1024 kilobytes, 1 kilobyte (KB) = 1024 bytes, 1 byte = 8 bits
        return megabytes * 1024 * 1024 * 8;
    }
    public static double convertMegaBytesToNibbles(double megabytes) {
        // 1 megabyte (MB) = 1024 kilobytes, 1 kilobyte (KB) = 1024 bytes, 1 byte = 2 nibbles
        return convertMegaBytesToBytes(megabytes) * 2;
    }
    public static double convertMegaBytesToBytes(double megabytes) {
        // 1 megabyte (MB) = 1024 kilobytes, 1 kilobyte (KB) = 1024 bytes
        return megabytes * 1024 * 1024;
    }
    public static double convertMegaBytesToKiloBytes(double megabytes) {
        // 1 megabyte (MB) = 1024 kilobytes
        return megabytes * 1024;
    }
    public static double convertMegaBytesToGigaBytes(double megabytes) {
        // 1 gigabyte (GB) = 1024 megabytes
        return megabytes / 1024;
    }
    public static double convertMegaBytesToTeraBytes(double megabytes) {
        // 1 terabyte (TB) = 1024 gigabytes
        return convertMegaBytesToGigaBytes(megabytes) / 1024;
    }


    // For TeraBytes
    public static double convertTeraBytesToBits(double terabytes) {
        // 1 terabyte (TB) = 1024 gigabytes, 1 gigabyte (GB) = 1024 megabytes, 1 megabyte (MB) = 1024 kilobytes, 1 kilobyte (KB) = 1024 bytes, 1 byte = 8 bits
        return terabytes * 1024 * 1024 * 1024 * 1024 * 8;
    }
    public static double convertTeraBytesToNibbles(double terabytes) {
        // 1 terabyte (TB) = 1024 gigabytes, 1 gigabyte (GB) = 1024 megabytes, 1 megabyte (MB) = 1024 kilobytes, 1 kilobyte (KB) = 1024 bytes, 1 byte = 2 nibbles
        return convertTeraBytesToBytes(terabytes) * 2;
    }
    public static double convertTeraBytesToBytes(double terabytes) {
        // 1 terabyte (TB) = 1024 gigabytes, 1 gigabyte (GB) = 1024 megabytes, 1 megabyte (MB) = 1024 kilobytes, 1 kilobyte (KB) = 1024 bytes
        return terabytes * 1024 * 1024 * 1024 * 1024;
    }
    public static double convertTeraBytesToKiloBytes(double terabytes) {
        // 1 terabyte (TB) = 1024 gigabytes, 1 gigabyte (GB) = 1024 megabytes, 1 megabyte (MB) = 1024 kilobytes
        return terabytes * 1024 * 1024 * 1024;
    }
    public static double convertTeraBytesToMegaBytes(double terabytes) {
        // 1 terabyte (TB) = 1024 gigabytes, 1 gigabyte (GB) = 1024 megabytes
        return terabytes * 1024 * 1024;
    }
    public static double convertTeraBytesToGigaBytes(double terabytes) {
        // 1 terabyte (TB) = 1024 gigabytes
        return terabytes * 1024;
    }


}
