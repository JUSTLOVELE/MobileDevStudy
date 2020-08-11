# Go
* [多线程](#thread)



<h2 id="thread">多线程</h2>

```golang
func Loop() {
	var wg sync.WaitGroup
	for i := 0; i < 5; i++ {
		wg.Add(1)
		go func(x int) {
			sendRPC(x)
			wg.Done()
		}(i)
	}
	wg.Wait()
}

func sendRPC(i int) {
	println(i)
}
```