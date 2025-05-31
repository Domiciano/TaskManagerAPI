import { Box, Grid, Typography } from "@mui/material";

import UserCard from "../components/UserCard";
import UserPostForm from "../components/UserPostForm";
import Post from "../components/Post";
import Comments from "../components/Comments";

function ComponentsPage() {
    const post = {
        id: 1,
        name: "Kevin Rodriguez",
        username: "KelooR",
        content: `Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                        Aenean congue metus libero, sed maximus arcu aliquet vitae. 
                        Fusce semper, ante eget eleifend tempor, neque nunc suscipit 
                        elit, ac finibus justo tortor vitae metus. Morbi sed est at 
                        enim ornare laoreet. Donec mollis justo eget posuere cursus. 
                        Curabitur viverra tellus in tincidunt mollis. Nulla facilisi`,
        createdAt: "2025-05-31T14:00:00",
        comments: [
            { 
                id: 1, 
                name: "Kevin Rodriguez", 
                username: "KelooR", 
                content: "¡Gran post!",
                createdAt: "2025-05-31T15:00:00"
            },
            { 
                id: 2, 
                name: "Usuario Genérico", 
                username: "User123", 
                content: "Interesante contenido, gracias por compartir.",
                createdAt: "2025-05-31T16:15:00"
            },
            { 
                id: 3, 
                name: "Jane Doe", 
                username: "JaneDoe", 
                content: "Me encanta tu estilo de escritura.",
                createdAt: "2025-05-31T17:00:00"
            }
        ]
    };

    return (
        <Box>
            <Typography variant="h2">Página de componentes</Typography>
            <Typography variant="body1">
                Aquí puedes ver ejemplos de los componentes que hemos creado.
            </Typography>

            <Grid container spacing={2} sx={{ mt: 2 }}>
                <Grid size={6}>
                    <UserCard name="Kevin Rodriguez" username="KelooR"/>
                </Grid>
                <Grid size={6}>
                    <UserPostForm name="Kevin Rodriguez" username="KelooR" />
                </Grid>
                <Grid size={6}>
                    <Post post={post} />
                </Grid>
                <Grid size={6}>
                    <Comments comments={post.comments} />
                </Grid>
            </Grid>
        </Box>
    );
}

export default ComponentsPage;