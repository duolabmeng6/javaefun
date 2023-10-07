package io.github.duolabmeng6.javaefun.util;

public class SnowflakeIdGenerator2 {

    private final static long START_STAMP = 1480166465631L;
    private final static long SEQUENCE_BITS = 12;
    private final static long MACHINE_BITS = 5;
    private final static long DATACENTER_BITS = 5;

    private final static long MAX_DATACENTER_ID = -1L ^ (-1L << DATACENTER_BITS);
    private final static long MAX_MACHINE_ID = -1L ^ (-1L << MACHINE_BITS);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BITS);

    private final static long MACHINE_SHIFT = SEQUENCE_BITS;
    private final static long DATACENTER_SHIFT = SEQUENCE_BITS + MACHINE_BITS;
    private final static long TIMESTAMP_SHIFT = DATACENTER_SHIFT + DATACENTER_BITS;

    private long datacenterId;
    private long machineId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowflakeIdGenerator2(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException("Invalid datacenterId");
        }
        if (machineId > MAX_MACHINE_ID || machineId < 0) {
            throw new IllegalArgumentException("Invalid machineId");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    public synchronized long generateUniqueId() {
        long currentTimestamp = getCurrentTimestamp();

        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id.");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                currentTimestamp = waitNextTimestamp();
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = currentTimestamp;

        return ((currentTimestamp - START_STAMP) << TIMESTAMP_SHIFT)
                | (datacenterId << DATACENTER_SHIFT)
                | (machineId << MACHINE_SHIFT)
                | sequence;
    }

    private long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    private long waitNextTimestamp() {
        long timestamp = getCurrentTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = getCurrentTimestamp();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        SnowflakeIdGenerator2 idGenerator = new SnowflakeIdGenerator2(2, 3);

        for (int i = 0; i < (1 << 12); i++) {
            System.out.println(idGenerator.generateUniqueId());
        }
    }
}
