USE [SPIC]
GO
/****** Object:  Table [dbo].[Musicas]    Script Date: 23/05/2019 19:49:16 ******/
DROP TABLE [dbo].[Musicas]
GO
/****** Object:  Table [dbo].[Musicas]    Script Date: 23/05/2019 19:49:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Musicas](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Titulo] [varchar](50) NOT NULL,
	[Artista] [varchar](50) NOT NULL,
	[Estilo] [varchar](50) NOT NULL,
	[Preco] [float] NOT NULL,
	[Duracao] [float] NOT NULL,
 CONSTRAINT [PK_Musicas] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Musicas] ON 

INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (1, N'Do I Wanna Know', N'Arctic Monkeys', N'Rock', 3.9, 4.26)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (2, N'Warriors', N'Imagine Dragons', N'Pop Rock', 1.5, 2.51)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (3, N'Dani California', N'Red Hot Chili Peppers', N'Rock', 2.59, 4.48)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (4, N'Hello', N'Adele', N'Pop', 1.99, 6.07)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (5, N'Congratulations', N'Post Malone', N'Hip-Hop', 2.27, 3.47)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (6, N'Poker Face', N'Lady Gaga', N'Pop', 1.15, 3.36)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (7, N'Bohemian Rhapsody', N'Queen', N'Rock', 2.79, 6.07)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (8, N'Billie Jean', N'Michael Jackson', N'Pop', 1.35, 4.54)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (9, N'Suspicious Minds', N'Elvis Presley', N'Rock', 0.75, 4.34)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (10, N'Mockingbird', N'Eminem', N'Rap', 2.49, 4.19)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (11, N'Diario de um Detento', N'Racionais MCs', N'Rap', 3.2, 7.31)
INSERT [dbo].[Musicas] ([ID], [Titulo], [Artista], [Estilo], [Preco], [Duracao]) VALUES (12, N'Farra, Pinga e Foguete', N'Bruno & Barreto', N'Sertanejo', 1.89, 2.42)
SET IDENTITY_INSERT [dbo].[Musicas] OFF
