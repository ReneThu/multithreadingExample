---
title: Multithreading under the lens what is VMLens and how can it help you?
info: |
  ## Slidev Starter Template
  Presentation slides for developers.

  Learn more at [Sli.dev](https://sli.dev)
# apply unocss classes to the current slide

# https://sli.dev/features/drawing
drawings:
  persist: false
# slide transition: https://sli.dev/guide/animations.html#slide-transitions
transition: slide-up
# enable MDC Syntax: https://sli.dev/features/mdc
mdc: true
# <!-- Empty slide -->
layout: center
---

<style>
.headline {
    font-weight: 1000;
    text-align: center;
    font-size: 50px;
}

.headline-smol {
    font-weight: bold;
    text-align: center;
}

.addonestuff {
    font-weight: bold;
    text-align: center;
}
.centerLogo {
    justify-items: anchor-center;
    transform: scale(0.3);
}
.sufferMeme {
    transform: scale(0.5);
}
.centerQrCOde {
    justify-items: anchor-center;
    transform: scale(0.3);
}
.img-center{
  display: flex;
  justify-content: center; /* center horizontally */
  align-items: center;     /* center vertically within the wrapper */
}

.intro-slide {
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  padding: 2rem;
  height: 100%;
}

.left {
  flex: 0 0 35%;
}

.right {
  flex: 0 0 60%;
  text-align: left;
}

.profile-img {
  width: 100%;
  height: auto;
  border-radius: 8px; /* optional: rounded corners */
}

.bullet-points {
  margin-top: 1.5rem;
  font-size: 1.2rem;
  line-height: 1.8;
}
</style>


<h1 class="headline">Multithreading under the lens: what is VMLens and how can it help you?</h1><br />

<br /><br />
<div class="centerLogo">
    <img src="./pictures/Dynatrace_Logo.png" alt=""/>
</div>

---
layout: full
layout: center
---

<h1 class="headline">Who are we?</h1><br />

---
layout: full
---

<div class="intro-slide">
  <div class="left">
    <img src="./pictures/Christian.png" alt="" class="profile-img" />
  </div>
  <div class="right">
    <h1 class="headline">Christian Lutnik</h1>
    <div class="addonestuff">Software Developer II at Dynatrace</div>
    <ul class="bullet-points">
      <li>Working on OpenFeature</li>
      <li>Mostly Java</li>
    </ul>
  </div>
</div>


---
layout: full
---

<div class="intro-slide">
  <div class="left">
    <img src="./pictures/marco_profi.jpg" alt="" class="profile-img" />
  </div>
  <div class="right">
    <h1 class="headline">Marco Sussitz</h1>
    <div class="addonestuff">Senior Software Developer at Dynatrace</div>
    <ul class="bullet-points">
      <li>Java Agent Dev</li>
      <li>Java/C++</li>
    </ul>
  </div>
</div>


---
layout: center
---

<div class="meme-wrapper" v-click>
  <h1 class="meme-text">
    4 out of 5 Dev suffer from multithreading. The one person that enjoys it
  </h1>
  <img src="./pictures/SufferFromMeme.png" alt="" class="meme-img"/>
</div>

<style>
.meme-wrapper {
  text-align: center;
  width: 60%;
  margin: 0 auto;
}

.meme-text {
  margin-bottom: 1rem;
  font-size: 1.5rem;
}

.meme-img {
  width: 100%;
  height: auto;
}
</style>

---
layout: center
---

<img v-click src="./pictures/MulithreadingMeme_1.jpg" alt="" class="meme-img"/>

---
layout: center
---

<img v-click src="./pictures/MulithreadingMeme_2.png" alt="" class="meme-img"/>

---
layout: center
---

<img v-click src="./pictures/MercyVMLensMeme.jpg" alt="" class="meme-img"/>

---
layout: center
---

<h1 class="headline">What is VMLens?</h1>

<div class="content">
  <ul class="bullet-points">
    <li v-click><strong>Concurrency testing tool</strong> for Java applications</li>
    <li v-click>Detects <strong>race conditions</strong> and <strong>deadlocks</strong> at runtime</li>
    <li v-click>Works with <strong>multithreaded code</strong> without manual instrumentation</li>
    <li v-click>Helps developers find bugs that only appear under specific timing conditions</li>
    <li v-click>Integrates with <strong>JUnit</strong> and popular Java frameworks</li>
  </ul>
</div>


<style>
.content {
  margin-top: 2rem;
  text-align: left;
  max-width: 80%;
  margin-left: auto;
  margin-right: auto;
}

.bullet-points {
  font-size: 1.3rem;
  line-height: 2;
}

.bullet-points li {
  margin-bottom: 1rem;
}
</style>


---
layout: center
---

<h1 class="headline">How does VMLens Work?</h1>

<div class="content">
  <ul class="bullet-points">
    <li v-click>Attaches a Java Agent</li>
    <li v-click>Agent keeps track of what the code does</li>
    <li v-click>Agent intercepts calls to <code>hasNext()</code></li>
    <li v-click>Creates report of test suite</li>
  </ul>
</div>


<style>
.content {
  margin-top: 2rem;
  text-align: left;
  max-width: 100%;
  margin-left: auto;
  margin-right: auto;
}

.bullet-points {
  font-size: 1.3rem;
  line-height: 2;
}

.bullet-points li {
  margin-bottom: 1rem;
}
</style>
---
layout: center
---

<br />
<h1 class="headline"> Disclaimer: Java Memory Model</h1>

<div class="disclaimer-box">
  <p class="disclaimer-text">
    The following content discusses the <strong>Java Memory Model (JMM)</strong> and concurrent programming concepts.
  </p>
  <p class="disclaimer-text">
    This is a <strong>simplified overview</strong>. The actual JMM specification is complex and nuanced.
  </p>
  <p class="disclaimer-text">
    For production code involving concurrency:
  </p>
  <ul class="disclaimer-list">
    <li >Consult the official <strong>Java Language Specification chapter 17</strong></li>
  </ul>
</div>

<style>
.disclaimer-box {
  background: rgba(255, 200, 100, 0.1);
  border: 2px solid #ff9800;
  border-radius: 12px;
  padding: 2rem;
  max-width: 80%;
  margin: 2rem auto;
  text-align: left;
}

.disclaimer-text {
  font-size: 1.2rem;
  margin-bottom: 1rem;
  line-height: 1.6;
}

.disclaimer-list {
  font-size: 1.1rem;
  line-height: 1.8;
  margin-top: 1rem;
}

.disclaimer-list li {
  margin-bottom: 0.5rem;
}
</style>

---
layout: center
---

<div class="meme-wrapper">
  <h1 class="meme-text">GeeCON 2018: Aleksey Shipilëv - Java Memory Model Unlearning Experience</h1>
  <img src="./pictures/JavaMemoryModelUnlearning.png" alt="" class="meme-img"/>
</div>

<style>
.meme-wrapper {
  text-align: center;
  width: 40%; 
  margin: 0 auto;
}

.meme-text {
  margin-bottom: 1rem; /* space between text and image */
  font-size: 1.5rem;
}

.meme-img {
  width: 100%;
  height: auto;
}
</style>

---
layout: center
---

<div class="meme-wrapper">
  <h1 class="meme-text">Close Encounters of The Java Memory Model Kind</h1>
  <img src="./pictures/CloseEncountersOfTheMemoryKind.png" alt="" class="meme-img"/>
</div>

<style>
.meme-wrapper {
  text-align: center;
  width: 60%; 
  margin: 0 auto;
}

.meme-text {
  margin-bottom: 1rem; /* space between text and image */
  font-size: 1.5rem;
}

.meme-img {
  width: 100%;
  height: auto;
}
</style>

---
layout: center
---

<div class="meme-wrapper">
  <h1 class="meme-text">Safe Publication and Safe Initialization in Java</h1>
  <img src="./pictures/SafePublication.png" alt="" class="meme-img"/>
</div>

<style>
.meme-wrapper {
  text-align: center;
  width: 60%; 
  margin: 0 auto;
}

.meme-text {
  margin-bottom: 1rem; /* space between text and image */
  font-size: 1.5rem;
}

.meme-img {
  width: 100%;
  height: auto;
}
</style>

---
layout: center
---

<h1 v-click class="headline">VMLens in Practice</h1><br />


---
layout: center
---
<div>
  <h1 v-click>How Does OpenTelemetry Achieve This?</h1>
</div>
<div class="image-container">
  <img 
    v-click
    class="fit-picture-elmoOtel"
    src="./pictures/otelElmoMemePg13.jpg"
  />
</div>

<style>
  .fit-picture-elmoOtel {
    width: 600px;
    height: auto; /* Maintains aspect ratio */
  }

  .image-container {
    display: flex;
    justify-content: center; /* Centers the image horizontally */
    align-items: center; /* Centers the image vertically (if needed) */
  }
</style>


---
layout: center
---

<h1>What are agents?</h1>

<ul>
  <li v-click>
    Provides services that allow Java programming language agents to instrument programs running on the JVM. The mechanism for instrumentation is modification of the byte-codes of methods.
  </li>
  <li v-click>
    Used for profiling, debugging, and monitoring.
  </li>
  <li v-click>
    -javaagent:&lt;jarpath&gt;[=&lt;options&gt;]
  </li>
    <div v-click>
```docker{all}
mvn -DargLine="-javaagent:.../target/vmlens-agent/agent.jar" test
```
    </div>
</ul>
---
layout: center
---

<v-click>
  <div class="image">
      <img src="./pictures/CarlSagan.png" alt=""/>
  </div>
</v-click>

<!--
There is qute from Carl Sagan.
If you wish to make an apple pie from scratch, you must first invent the universe.

If we really want to understand how code hotswapping works we first need to understand
how classes are loaded in the JVM
-->

---
layout: center
---

<v-click>
  <h1>What happens during class loading?</h1>
</v-click>

<div>
  <ul>
      <li v-click>
        <span v-mark.underscore.orange=6>
          Loading
        </span>
      </li>
    <li v-click>Verify</li>
    <li v-click>Prepare</li>
    <li v-click>(Optionally) Resolve</li>
  </ul>
</div>

<!--
chaper 12 of the java langues specification as well as chaper 5 of the java virtual machine specification talk about that.
So there are 5 steps that are taken.

The first one loading. 
So if a class is requested that is not laoded classloader will be used to look for a bianry representation of the class.

Verification:
This means that the class is checkt that it is well-formated. So with a proper symbol table and so on.

Preparation:
static storage and any data structures

Resolution(optional):

checking symbolic references from the class to other
classes and interfaces.

The Loading step is the one we are interested in.
-->

---
layout: center
---

<v-click>
  <h1>Observe when classes are loaded</h1>
</v-click>

<v-clicks>
<div>
```java{all}
void JNICALL
ClassFileLoadHook(jvmtiEnv *jvmti_env,
        JNIEnv* jni_env,
        jclass class_being_redefined,
        jobject loader,
        const char* name,
        jobject protection_domain,
        jint class_data_len,
        const unsigned char* class_data,
        jint* new_class_data_len,
        unsigned char** new_class_data)
```
</div>

</v-clicks>

---
layout: center
---

<v-clicks>
<h1>Is there a better way?</h1>
</v-clicks>

<div>
  <ul>
    <li v-click>Java Agents</li>
    <li v-click>java.lang.instrument</li>
    <li v-click>java -javaagent:agent.jar -jar helloWorld.jar</li>
  </ul>
</div>

---
layout: center
---

<v-clicks>

````md magic-move{lines: true}
```java{all|2}
public class SampleAgent {
    public static void premain(String arguments, Instrumentation instrumentationObject) {
    } 
}
```

```java{all|3}
public class SampleAgent {
    public static void premain(String arguments, Instrumentation instrumentationObject) {
        instrumentationObject.addTransformer(new OptimusPrime(), false);
    }
}
```
````
</v-clicks>

---
layout: center
---

<v-clicks at="1">
<div>
````md magic-move{lines: true}
```java{all|all|3-7|3|4|5|6|7|8|all}
public class OptimusPrime implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classFileBuffer) throws IllegalClassFormatException {
        return transformClassFile(classFileBuffer);
    }
}
```
```java{all}
public class OptimusPrime implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classFileBuffer) throws IllegalClassFormatException {
        return transformClassFile(classFileBuffer);
    }

    public byte[] transformClassFile(byte[] classfileBuffer) {
        //TODO
        return null;
    }
}
```
````
</div>
</v-clicks>

---
layout: center
zoom: 2
---

<div>
  <ul>
    <li v-click>Java Meta-Agent</li>
    <li v-click>a custom build JVM</li>
  </ul>
</div>

---
layout: center
---

<div class="meme-wrapper">
  <h1 class="meme-text">Who instruments the native instrumenters?</h1>
  <img src="./pictures/mostlynerdless.png" alt="" class="meme-img"/>
</div>

<style>
.meme-wrapper {
  text-align: center;
  width: 60%; 
  margin: 0 auto;
}

.meme-text {
  margin-bottom: 1rem; /* space between text and image */
  font-size: 1.5rem;
}

.meme-img {
  width: 100%;
  height: auto;
}
</style>


---
layout: center
---

<v-click>
  <h1>Recap</h1>
</v-click>

<div>
  <ul>
    <li v-click>TODO</li>
    <li v-click>TODO</li>
    <li v-click>TODO</li>
  </ul>
</div>

---
layout: center
---


<h1 class="headline">Questions?</h1><br />

<br /><br />
<div class="centerLogo">
    <img src="./pictures/Dynatrace_Logo.png" alt=""/>
</div>