   M S B A M L   `   `   `  ����D  @FurgolApp, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:FurgolApp	FurgolApp  5   	       FurgolApp.Nuevo_Jugador   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   )localclr-namespace:FurgolApp     5   	     � Title$  	FurgolApp��5   	   $	��450��5	   	   $	��550��5
   	    � 
ResizeMode$ NoResize=�5   	    � WindowStartupLocation$ CenterScreen=�5   	    � WindowStyle$
 None=�5   	   .��5      �� ��5   
   �� 5       �� ImageSource$ /img/background.png��6    j� Stretch$ UniformToFill=�5      .+�5   
   ��  �� Orientation$ 
Horizontal=�6   .+�5      �� -   5        $��Guardar��5       	  Hover#��[  5      $	��100��5      $��
20 50 0 30q�5       5!      �� 5$      -   5        $��Cancelar��5$      #��[  5%      $	��100��5&      $��
20 50 0 30q�5'      5(      �� 5+      -   5        $��Limpiar��5+      #��[  5,      $	��100��5-      $��
20 50 0 30q�5.      5/      50      � 53   
    � ColumnDefinitions 55      �� 56      $��* �6#   �� 57      $
��auto �6#    � RowDefinitions 5;      �� 5<      $	��300 �6    �� 5=      $��* �6    .+�5A      �� $��0��6   $��	20 20 0 0q�5B      .+�5C         FurgolApp.PersonalTextBox  -   5        	  Name$	 campoNombre��5D   )   
   Etiqueta$
 Nombre:��5C   (   5D   )     5E      -   5        $	 campoApellidos��5F   )   $
 
Apellidos:��5E   (   5F   )     5G      -   5        $	 
campoApodo��5H   )   $
 Apodo:��5G   (   5H   )     5I      -   5        $	 	campoEdad��5J   )   $
 Edad:��5I   (      LargoMaximo$ 2��5K   )     5L      -   5        $	 campoNacionalidad��5M   )   $
 Nacionalidad:��5L   (   5M   )   5N      � 5Q      $��1��6    5R      �� 5S      $
��Auto �6$   �� 5T      $��20 �6$   �� 5U      $��20 �6$   .+�5Y         FurgolApp.PersonalImage  -	   5          Name$ 
Fotografia��5Y   &      ImagenPredeterminada$ ./img/jugador.png��5Z   &   $��0��5[   &   �� 5^      -
   5         ��Name$ Insertar_Foto��5^      $��	10 0 20 0q�5_      $��1��5`      $��Añadir Fotografia��5a      5b      �� 5e      -   5        $ Limpiar_Foto��5e      $��	10 0 20 0q�5f      $��2��5g      $��Limpiar Fotografia��5h      5i      5k      5l      5m      5n      