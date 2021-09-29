## W02

### Task 1

#### 1. 类图与时序图

类图：

![character1](http://www.plantuml.com/plantuml/svg/ZLGzJyCm4DtzApo2sbHYhwBIfGj3HO45CRZ9qLguTkGFe9J-Twwnpqa4hSWIt_doxhrtfyoS5zQ7dUBLLbXHUR0tZ4cDxrTH0LyPYqT-O1oV4LT6r5VNAN1ubuCD-AKI6kCZOvKIpl5vMAyL310AZj3FBroaQEMjr1lUu9Tj9gNTXsWoSkp9frFp3jRA6ifoGE2lcyncU8dK1gIAuhjC4edq0k2hH_U0_dXP7Idljn1F92024KPCneeaeE2Di0wIEJ43dr053ttp7WYuinTyXEsSa1eUcsXnDw8xgGLAoZF2xvR6II-D7apdZzoJK04Y7kYmumiJRDqV5RVZzRXACI7m9XrOXxIm9kXwlhyN-YrtiFt0cpZiCwFi4pmtqOi5fvsveF7N8aIjxGOa1sa5C8Hi0a7Yqf9iHxgRCDZ_VqhrvjPQiSVg4utKCtjBVMcgYhXbdz9D75lBTLHqF5bQL5FGScQbPLT4LPD9gnuYJefYlnde6lyBFm00 "character1")

时序图：

![timeline1](http://www.plantuml.com/plantuml/svg/ZPDDIm916CVlyoaUsBEGlHqyX0IRUN73oeheiEIJ2kjkZ2DX9qFiXL91AW8F4HJL8GWyM5BqPTnLlqKxwuux4C727ePvVhzv7lup6oyndR9oqG1MAA9HC35AYBxFB0e0e-h9yBpdVW1w2O3bCO5uZ7GAs8_FzalDNNXrBQM2aiRij3peNqdbZIqD58tgPWu3ukD29bRJgkgkbHqq3EieQDFfIDIAjfdcQoL14KsfsRKC9JEgW2h1GVKtYLbFReEoR9JbSMfoNSseANx6MfaU6aZGP0LM0N2QRRlVScu_dUwDO4iMPMum0XdVtG--6gB8OoM4nnFPzGRQYonvcn23qK_7hZyHqs88j93BinWisgtUuBj1U62XX3aXUFc5KgA-ueKPobWG1aysb37h6ppdKCAy4BpWGoaplaAcZzFtqEHYi1i3-wm_RBx_HqukqCN6rGldydNInC03juTzsdQw3vDR_wlB0mecZcRM_QT-0G00 "timeline1")

#### 2. example 的设计理念的好处及可改进之处

##### 好处：

+ 排序的内容抽象为 `Linable` 接口，只要存在偏序关系的事物都可以排；
+ 合理的继承，`Gourd` 属于“可排序的事物”，自然地应用 `Linable` 接口，将现实的“葫芦娃”自然地转化为抽象的 `Linable` 的一种实体。
+ 没有直接对 `line` 中的内容进行排序，而是通过对其内容的分析后得到排序步骤再进行 `line` 中元素位置的改变，更贴近现实，贴近自然，容易理解，符合 OOP 的设计理念。

##### 可改进之处：

+ `Line` 是数据存在的一种形式，除 `Line` 之外应该还有其他形式（比如矩阵），而他们共有的特性就是每个元素都有一个位置，都可以通过get、put等获取和修改其中的元素，所以我认为可以将 `Position` 属性以及 `get()`, `put()`, `toArray()` 等方法提升到父类中，不同的数据存在形式只要继承这个父类即可。
+ （有一个小bug，如果队伍本来就是排好序的，排序步骤为空，在`Geezer.execute()` 方法中会出现空指针错，在任务二中提供了一种补丁式的修改方法，期待看到更优的方法）

### Task 2

#### 类图：

![character2](http://www.plantuml.com/plantuml/svg/ZLLDJzmm4BtxLrZgfHM4Gw-i8igbGWAfPLikLGzUPxfO12Ur7LYW_FTEuXd7QHBKbLOxdXdFl3SVtZCVb0lTVItrhN9A1t0VXJ0MVtyf3NBRE1JbYv3uEP9rewht7-ZWqPOEUmXVQcNn_2g4hfNtyhpRxMgOH7WdCVIFdrBHQHkSiNlPuir1Gsh_gDeKEUQKcqtp0CwP2ifo0c39aj1CZGXj0gee_fH4aK5_xOo--uVrMfv2_cPlGbl85ijfWcce4dcu8LkUdtDkeGOT_Zkf7zolrE72Ld28UIOXLXDz1dXEAGhvWiqFHh-oFjn2bCXEuJX6L4QFdAy7wdpKm05q5o2VZ6ySU9mT8B1Zcus5xsraCyxVfR4AQOnLmSOsdWiyDdj1TwFg3l9vtBRE1F1p-cn0_b6yKdOFxdJP3yVNnmipXqlZm-O2mUFjKZfbg-Q-ryqSaI1-iNkdWW0RQmBXo4b4rVdJjR9tkVvwY3rdbyZr6TpnxbZJcIiaMn8uiSiZXoPkvCg-vOLUMxit7Vh5VgDNisqbKiD0qoXCNYS8QJBQRl8OPPG-EQUUyb9XfB5G30VRogNn8e-vGdJPaB8j6vUhYy06IF4vWi0uKyyOAsz3pQL8VI4BFmP17XKZDK7xtHIyqsDXoz6Brw2_6cN1DqzE8h0-SY-dNfo1hV3Vuoy0 "character2")

#### 可视化结果：

##### 1）快速排序

**由于快速排序录制结果文件太大无法上传，所以使用64个“小妖”来做**

<video id="video" controls="" preload="none" poster="https://asciinema.org/a/TFWlWZtlv3iV4aozGnRfkR9PR.svg">
      <source id="mp4" src="https://asciinema.org/a/TFWlWZtlv3iV4aozGnRfkR9PR" type="video/mp4">
</videos>

##### 2）选择排序

<video id="video" controls="" preload="none" poster="https://asciinema.org/a/dhiXwensvSRzfbVLf4WKDg6nL.svg">
      <source id="mp4" src="https://asciinema.org/a/dhiXwensvSRzfbVLf4WKDg6nL" type="video/mp4">
</videos>
