# Filters

- TO change
  R = Rc/127.5*avg for avg < 128
  (2 - Rc/127.5)*avg + 2\*Rc - 255 for avg >=128
  To apply this formula and create a colored filter of your choice, use a color picker tool to determine the RGB content of any color you would like to use, such as teal (17,170,153).

Since for teal, Rc = 17, Gc = 170, Bc = 153, so
R = 17/127.5*avg = 0.13*avg for avg < 128
(2 - 17/127.5)*avg + 2*17 - 255 = 1.87\*avg - 221 for avg >=128

G = 170/127.5*avg = 1.33*avg for avg < 128
(2 - 170/127.5)*avg + 2*170 - 255 = 0.67\*avg + 85 for avg >=128

B = 153/127.5*avg = 1.2*avg for avg < 128
(2 - 153/127.5)*avg + 2*153 - 255 = 0.8\*avg + 51 for avg >=128
