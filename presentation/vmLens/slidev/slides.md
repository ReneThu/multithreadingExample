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

<div class="meme-wrapper">
  <h1 class="meme-text">4 out of 5 Dev suffer from multithreading. The one person that enjoys it</h1>
  <img src="./pictures/SufferFromMeme.png" alt="" class="meme-img"/>
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
