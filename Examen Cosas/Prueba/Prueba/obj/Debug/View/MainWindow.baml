   M S B A M L   `   `   `  ����A  =Prueba, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullclr-namespace:PruebaPrueba  5   	       Prueba.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   &localclr-namespace:Prueba     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      �� $��Task Manager��6   
���   �$��3,3,3,3q�69   .��5
   
   � .+�5      �� $��Create and Delete Task��6   $��10,10,375,10q�67   
���   �$��1.5,1.5,1.5,1.5q�6a   .��5      � .+�5      �� -   5         ��Name$	 NEW��5      $	��NEW��6*   $
��Left=�68   $	��Top=�6S   $��70��6k   $��	10,10,0,0q�6v   $
��Bold"�6�   6�   �� 5      -   5        $ DELETE��5      $��DELETE��6-   $
��Left=�6>   $	��Top=�6Y   $��70��6q   $��	85,10,0,0q�6|   $
��Bold"�6�   6�   &   System.Windows.Controls.DataGrid  5      -   5          Name$ dgTask��5      $��
10,35,9,10q�6Z      AutoGenerateColumns .     CanUserAddRows .     CanUserDeleteRows .     CanUserResizeRows .     CanUserReorderColumns .     Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn	   Header$
	 NAME��61   1  +System.Windows.Controls.DataGridBoundColumn
   Binding
 6?   �� *name+  5      $	 DESCRIPTION��61      
Foreground
 �   �
 6Y   �� *description+4  .System.Windows.Controls.DataGridCheckBoxColumn  5      $	 COMPLETE��65      IsThreeState . 
 6G   �� *isCompleted+6g   5      5      5      �� 5      $��	Edit Task��6   $��418,10,10,10q�6*   
���   �$��1.5,1.5,1.5,1.5q�6T   .��5      � .+�5      �� -   5        $
 SAVE��5      $
��SAVE��6+   $��Center=�6:   $	��Top=�6W   $	��212��6o   $��	0,322,0,0q�6{   $
��Bold"�6�   6�   �� 5      -   5         ��Name$
 NAME��5      $��Center=�6,   $��0,41,0,0q�6I    �� TextWrapping$
 Wrap=�6[   $	��Top=�6o   $	��158��6�    � ToolTip$ 	Task Name��6�   �� 5      $��Name:��6   $��Center=�6,   $��0,10,0,0q�6I   $	��Top=�6[   $
��Bold"�6s   �� 5      -   5        $ DESCRIPTION��5      $��Center=�63   $
 Wrap=�6P   $��Center=�6d   $	��158��6   $ 	Task Name��6�   $	��152��6�   �� 5      $��Description:��6   $��Center=�63   $��0,77,0,0q�6P   $	��Top=�6b   $
��Bold"�6z   �� 5      -   5         ��Name$ 	COMPLETED��5      $��	Completed��62   $��Center=�6F   $��	0,283,0,0q�6c   $	��Top=�6v   $
��Bold"�6�   5       5!      5"      5#      5$      