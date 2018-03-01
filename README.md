# LetterAvatar
A Material-Design-like avatar that displays the first letter of a user's name. Similar to those shown at inbox.google.com

![Prime Example](https://i.imgur.com/OsmmaMe.png)


## It's SceneBuilder compatible!

1. Clone this repository and run `mvn clean install` in the root of the project.
2. Add to SceneBuilder
    1. ![Add to SceneBuilder Animation](https://i.imgur.com/7DHuDJQ.gif)

## Sample Usage
```java            
// The argument will determine the background color; this will always be the same color for the same input.
// This assumes you want the avatar's letter to be the first letter of the user's name.
LetterAvatar la = new LetterAvatar(user.getName());

// If you want to be explicit about which letter to use, use this constructor.
LetterAvatar la = new LetterAvatar("B", "some unique-to-the-user value");
```
---

## Change Avatar Character
I designed LetterAvatar to have one character, but if you felt like it, maybe you could put two.

    letterAvatar.setAvatarCharacter("Z");
    
## Change Size
`LetterAvatar` changes its size based on the font size, so all you have to do is make the font a little bigger and the background circle will automatically grow.

    letterAvatar.setFont(Font.font(32));
    
## Change Background Color Pallete
`LetterAvatar` uses the [Material Design Color Palletes].

By default I assume you want to use *all* of them and so the only thing left to do is to decide **how dark**—I call this the color number for lack of a better phrase.

### Darkness

    leterAvatar.setColorNumber("100");
    
    ![the gammut](https://i.imgur.com/GRLyJYo.png)

You can pick
<ul>
<li>50</li>
<li>100</li>
<li>200</li>
<li>300</li>
<li>400</li>
<li>500</li>
<li>600</li>
<li>700</li>
<li>800</li>
<li>900</li>
<li>A100</li>
<li>A200</li>
<li>A400</li>
<li>A700</li>
</ul>
</p>
*A100, A200, A400, and A700 are not available for brown, grey and blue-grey.

#### Font Color
If you find yourself hating the fact that at a certain darkness some colors require a white font fill and others don't,
 1. [Blame](https://gist.github.com/maxd/63691840fc372f22f470#file-modena-css-L112) [JavaFX](https://gist.github.com/maxd/63691840fc372f22f470#file-modena-css-L204) :smile:
 2. In your stylesheet, override the -fx-text-fill using something like this
    
    .letter-avatar {
        -fx-text-fill: white;
    }
    
### Hues
The hues are looked up from a stylesheet that `LetterAvatar` holds inside it. Theoretically, if you were to maintain the pattern, at runtime you could add and take away hues from `letterAvatar.getHues()`. This would be your stratgey if you wanted to use accent colors (because brown, grey and blue-grey don't have accent colors).

    
[Material Design Color Palletes]: https://material.io/guidelines/style/color.html#color-color-palette
