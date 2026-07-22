<div align="center">
  <h1>SCDMM</h1>
  <p><strong>S</strong>ynced <strong>C</strong>ross <strong>D</strong>evice <strong>M</strong>od <strong>M</strong>anager</p>
  <a href="https://fabricmc.net/">
    <img src="https://colbster937.github.io/devins-badges/assets/cozy/supported/fabric_vector.svg">
  </a>
  <a href="https://ornithemc.net/">
    <img src="https://colbster937.github.io/devins-badges/assets/cozy/supported/ornithe_vector.svg">
  </a>
  <br>
  <a href="https://modrinth.com/mod/scdmm">
    <img src="https://colbster937.github.io/devins-badges/assets/cozy/available/modrinth_vector.svg">
  </a>
  <a href="https://github.com/colbster937/btnposfix">
    <img src="https://colbster937.github.io/devins-badges/assets/cozy/available/github_vector.svg">
  </a>
</div>
<br>
When syncing a single instance across multiple devices, there may be some mods that are incompatible / you just don't want on that device (e.g. pojavlauncher).
<br><br>
<h3>How it works:</h3>
SCDMM uses <a href="https://modrinth.com/mod/relauncher">relauncher</a> to automatically set the <code>-Dfabric.addMods</code> to load mods from a platform-specific directory.
<br><br>
As there isn't any fabric dependent code here, this should work for all fabric loader versions supporting the addMods system property, and all minecraft versions supported by relauncher.
<br><br>