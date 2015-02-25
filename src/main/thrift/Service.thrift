namespace java thrift

service MathService {
	void ping(),
	void pingWithDelay(1: i64 delay),
	i32 sum(1: i32 a, 2: i32 b)
}
