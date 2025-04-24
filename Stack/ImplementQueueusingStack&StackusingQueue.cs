//225. Implement Stack using Queues

### ✅ **Approach: Using Two Queues**
Let’s name them `q1` and `q2`.

- **Push(x)**: Enqueue into `q2`, then dequeue all from `q1` into `q2`, then swap `q1` and `q2`.  
- **Pop()**: Dequeue from `q1`.  
- **Top()**: Peek from `q1`.  
- **Empty()**: Check if `q1` is empty.

> This keeps the **most recently pushed element at the front of `q1`**, simulating a stack.

---

### 💻 **C# Implementation**

```csharp
using System;
using System.Collections.Generic;

public class MyStack
{
    private Queue<int> q1;
    private Queue<int> q2;

    public MyStack()
    {
        q1 = new Queue<int>();
        q2 = new Queue<int>();
    }

    // Push element x onto stack.
    public void Push(int x)
    {
        q2.Enqueue(x);

        // Move all elements from q1 to q2
        while (q1.Count > 0)
        {
            q2.Enqueue(q1.Dequeue());
        }

        // Swap q1 and q2
        var temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on the top of the stack and returns it.
    public int Pop()
    {
        if (q1.Count == 0) throw new InvalidOperationException("Stack is empty");
        return q1.Dequeue();
    }

    // Get the top element.
    public int Top()
    {
        if (q1.Count == 0) throw new InvalidOperationException("Stack is empty");
        return q1.Peek();
    }

    // Returns whether the stack is empty.
    public bool Empty()
    {
        return q1.Count == 0;
    }
}
```

---

### 🧪 **Test the Stack**

```csharp
public class Program
{
    public static void Main()
    {
        MyStack stack = new MyStack();
        stack.Push(1);
        stack.Push(2);
        Console.WriteLine(stack.Top());   // returns 2
        Console.WriteLine(stack.Pop());   // returns 2
        Console.WriteLine(stack.Empty()); // returns False
    }
}
```

---

### 🧠 **Time Complexity**
- **Push**: O(n) due to shifting elements
- **Pop / Top / Empty**: O(1)


---------------
//232. Implement Queue using Stacks

## ✅ **Approach: Two Stack Method**

### 🔹 Use Two Stacks:
- `inStack`: for **push**
- `outStack`: for **pop** and **peek**

### 💡 Core Idea:
- **Push**: Just push into `inStack`
- **Pop/Peek**: 
  - If `outStack` is empty, **transfer all elements from `inStack` to `outStack`**
  - Then, pop/peek from `outStack`



```csharp
using System;
using System.Collections.Generic;

public class MyQueue
{
    private Stack<int> inStack;
    private Stack<int> outStack;

    public MyQueue()
    {
        inStack = new Stack<int>();
        outStack = new Stack<int>();
    }

    // Push element x to the back of the queue.
    public void Push(int x)
    {
        inStack.Push(x);
    }

    // Removes the element from in front of queue and returns that element.
    public int Pop()
    {
        MoveInToOut();
        return outStack.Pop();
    }

    // Get the front element.
    public int Peek()
    {
        MoveInToOut();
        return outStack.Peek();
    }

    // Returns whether the queue is empty.
    public bool Empty()
    {
        return inStack.Count == 0 && outStack.Count == 0;
    }

    // Helper to shift elements if outStack is empty
    private void MoveInToOut()
    {
        if (outStack.Count == 0)
        {
            while (inStack.Count > 0)
            {
                outStack.Push(inStack.Pop());
            }
        }
    }
}
```

---

## 🧪 Test Code

```csharp
public class Program
{
    public static void Main()
    {
        MyQueue myQueue = new MyQueue();
        myQueue.Push(1); // queue: [1]
        myQueue.Push(2); // queue: [1, 2]
        Console.WriteLine(myQueue.Peek());  // Output: 1
        Console.WriteLine(myQueue.Pop());   // Output: 1
        Console.WriteLine(myQueue.Empty()); // Output: False
    }
}
```

---

## ⏱️ Time Complexity (Amortized)
- `Push`: O(1)
- `Pop`: O(1) amortized (worst-case O(n) during transfer)
- `Peek`: O(1) amortized
- `Empty`: O(1)

---
